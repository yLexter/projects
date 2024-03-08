package entities;

/**
 * Esta classe representa a relação entre um estudante e uma disciplina.
 * Ela herda os atributos e comportamentos da classe Subject.
 */
public class SubjectStudent extends Subject {
    private Float note1 = null;
    private Float note2 = null;
    private Float finalExameScore = null;
    private String studentId;
    private Integer absences = 0;
    private String idCollegeClass;

    public SubjectStudent(String code, String name, int hours, String studentId, String idCollegeClass) {
        super(code, name, hours);
        this.studentId = studentId;
        this.idCollegeClass = idCollegeClass;
    }


}
