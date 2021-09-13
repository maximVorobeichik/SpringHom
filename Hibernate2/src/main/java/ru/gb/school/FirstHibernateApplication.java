package ru.gb.school;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class FirstHibernateApplication {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        SchoolClass newClass = new SchoolClass("11F");
        entityManager.persist(newClass);

        StudentDetail newStudentDetail = new StudentDetail("Prague", 44, "+321487198", "maksym.d@tt.ru");
        Student newStudent = new Student("Maks", "Dobrynin", newStudentDetail, newClass);
        entityManager.persist(newStudent);

        StudentDetail newStudentDetail2 = new StudentDetail("London", 55, "+82621487198", "london.jack@ll.uk");
        Student newStudent2 = new Student("Jack", "London", newStudentDetail2, newClass);
        entityManager.persist(newStudent2);



        entityManager.getTransaction().commit();



//        SELECT * FROM STUDENTS
//        SELECT s.name, s.surname FROM STUDENTS s
        List<Student> resultList = entityManager
                .createQuery("select stud from Student as stud", Student.class)
                .getResultList();
        System.out.println(resultList);

    }
}
