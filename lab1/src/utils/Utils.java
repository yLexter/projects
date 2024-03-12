package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.util.function.Function;

public class Utils {

    public static <T> ArrayList<T> getIntersectionBetweenLists(List<T> list1, List<T> list2) {
        List<T> listWithoutDuplicates = list1
                .stream()
                .filter(item -> !list2.contains(item))
                .toList();

        return new ArrayList<T>(listWithoutDuplicates);
    }


}
