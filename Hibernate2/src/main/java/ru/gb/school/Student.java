package ru.gb.school;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "surname")
    private String surname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private StudentDetail detail;
    @ManyToOne
    @JoinColumn(name = "school_class_id", nullable = false)
    private SchoolClass schoolClass;

    public Student(String name, String surname, StudentDetail detail, SchoolClass schoolClass) {
        this.name = name;
        this.surname = surname;
        this.detail = detail;
        this.schoolClass = schoolClass;
    }

    public Student(int id, String name, String surname, StudentDetail detail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.detail = detail;
    }

    public Student(String name, String surname, StudentDetail detail) {
        this.name = name;
        this.surname = surname;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public StudentDetail getDetail() {
        return detail;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
