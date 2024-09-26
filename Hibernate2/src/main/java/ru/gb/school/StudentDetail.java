package ru.gb.school;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_DETAILS")
public class StudentDetail {
    @Id
    @GeneratedValue
    private int id;
    private String address;
    private int age;
    private String telephoneNumber;
    private String email;

    public StudentDetail(String address, int age, String telephoneNumber, String email) {
        this.address = address;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public StudentDetail(int id, String address, int age, String telephoneNumber, String email) {
        this.id = id;
        this.address = address;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
