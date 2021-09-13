package ru.gb.school;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "SCHOOL_CLASS")
public class SchoolClass {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL) //каскадная на все (доб.уд...)
    private List<Student> students;

    public SchoolClass(String name) {
        this.name = name;
    }

    public SchoolClass(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public SchoolClass(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
