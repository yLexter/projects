package entities;

import java.util.*;


/**
 * Essa classe representa uma turma
 * */
public class CollegeClass extends Subject {
        private String teacherId;
        private ArrayList<SubjectStudent> students;
        private String collegeClassId;
        private List<String> classSchedules;

        public CollegeClass(String code, String name, int hours, String teacherId) {
                super(code, name, hours);
                this.teacherId = teacherId;
                this.collegeClassId = UUID.randomUUID().toString();
                this.students = new ArrayList<>();
                this.classSchedules = new ArrayList<>();
        }

}

