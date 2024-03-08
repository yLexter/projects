package entities;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Essa classe representa o cronograma de uma aula. Ela contém informações como horário, dia da semana, identificação,
 * ID da turma e ID da sala.
 */

public class ClassSchedule {
    private LocalTime time;
    private DayOfWeek dayOfWeek;
    private final String id;
    private String collegeClassId;
    private String roomId;

    public ClassSchedule(LocalTime time, DayOfWeek dayOfWeek, String collegeClassId, String roomId) {
        this.time = time;
        this.dayOfWeek = dayOfWeek;
        this.collegeClassId = collegeClassId;
        this.id = UUID.randomUUID().toString();
        this.roomId = roomId;
    }


}