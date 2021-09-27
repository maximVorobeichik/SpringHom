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
        Student newStudent = new Student("Maks", "Dobrynin", "maks.dobrynin@tt.ru");
        entityManager.persist(newStudent);
        entityManager.getTransaction().commit();

        Student student = entityManager.find(Student.class, 1);
        System.out.println(student);

        entityManager.getTransaction().begin();
        student.setEmail("maks.dobrynin.new@mm.com");
        entityManager.merge(newStudent);
        entityManager.getTransaction().commit();

        student = entityManager.find(Student.class, 1);
        System.out.println(student);

        entityManager.getTransaction().begin();
        Student newStudent2 = new Student("Maks2", "Dobrynin2", "maks.dobrynin2@tt.ru");
        entityManager.persist(newStudent2);
        entityManager.getTransaction().commit();

//        SELECT * FROM STUDENTS
//        SELECT s.name, s.surname FROM STUDENTS s
        List<Student> resultList = entityManager
                .createQuery("select stud from Student as stud", Student.class) //в начале запрос а потом выбираем какой тип возвращ. данных
                .getResultList();
        System.out.println(resultList);

    }
}
