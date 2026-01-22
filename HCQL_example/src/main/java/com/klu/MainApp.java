package com.klu;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MainApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int ch;
        do {
            System.out.println("\n=== MENU (HQL + HCQL) ===");
            System.out.println("1. Insert Student");
            System.out.println("2. Show Students (HQL)");
            System.out.println("3. HCQL - Students marks > 50");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    insert();
                    break;
                case 2:
                    showHQL();
                    break;
                case 3:
                    showHCQL();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (ch != 0);
    }

    // ================= INSERT =================
    static void insert() {
        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Student s = new Student(name, marks);
            session.persist(s);
            tx.commit();
            System.out.println("Student inserted successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // ================= HQL =================
    static void showHQL() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Student> query = session.createQuery("FROM Student", Student.class);
        List<Student> list = query.list();

        System.out.println("\nID   NAME   MARKS");
        for (Student s : list) {
            System.out.println(s.getId() + "   " + s.getName() + "   " + s.getMarks());
        }

        session.close();
    }

    // ================= HCQL (Criteria API) =================
    static void showHCQL() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);

        cq.select(root).where(cb.gt(root.get("marks"), 50));

        Query<Student> query = session.createQuery(cq);
        List<Student> list = query.getResultList();

        System.out.println("\nStudents with marks > 50:");
        for (Student s : list) {
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getMarks());
        }

        session.close();
    }
}
