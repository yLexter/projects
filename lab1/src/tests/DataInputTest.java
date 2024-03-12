package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import utils.Constants;
import utils.DataInput;

import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import erros.LeftMenuException;

public class DataInputTest {
    public Function<String, String> mockFunction;

    @BeforeEach
    public void setUp() {
        this.mockFunction = (x) -> "Teste";
    }

    @AfterEach
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void testGetElementFromListByUser() {
        List<String> options = List.of("Option 1", "Option 2", "Option 3");
        simulateInput("1\n");

        String selectedOption = DataInput.getElementFromListByUser(
                options,
                mockFunction,
                ""
        );

        assertEquals("Option 1", selectedOption);
    }

    @Test
    public void testGetElementsFromListByUser() {
        List<String> options = List.of("Option 1", "Option 2", "Option 3");

        simulateInput("1\n1\n%s\n".formatted(Constants.exitInputString));

        List<String> selectedOptions = DataInput.getElementsFromListByUser(
                options,
                mockFunction,
                ""
        );

        assertEquals(List.of("Option 1", "Option 2"), selectedOptions);
    }

    @Test
    public void testGetElementFromListByUserEmptyList() {
        List<String> options = List.of();

        assertThrows(
           LeftMenuException.class,
           () -> DataInput.getElementFromListByUser(options, mockFunction, "")
        );

        assertThrows(
                LeftMenuException.class,
                () -> DataInput.getElementsFromListByUser(options, mockFunction, "")
        );
    }

    private void simulateInput(String input) {
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
    }
    
    
}
