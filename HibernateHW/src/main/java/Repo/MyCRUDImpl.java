package Repo;

import POJO.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MyCRUDImpl implements MyCRUD{
    private SessionFactory sessionFactory;

    public MyCRUDImpl(){
    }

    @Override
    public boolean save(Student student) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            return true;
        }catch (Exception e){
            System.err.println("Cannot add student");
        }
        return false;
    }

    @Override
    public Student getStudentByID(long id) {
        List<Student> student = new ArrayList<>();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery( "from Student where id = :studentId" );
            query.setLong("studentId",id);
            student = (List<Student>) query.list();
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }catch (Exception e){

            System.err.println("Cannot get student with ID");
        }

        return student.get(0);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery( "from Student where name = :studentName" );
        query.setString("studentName",name);
        List<Student> students =  (List<Student>) query.list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return students;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> student = new ArrayList<>();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery( "from Student where id > :studentId" );
            query.setLong("studentId",0);
            student = (List<Student>) query.list();
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }catch (Exception e){

            System.err.println("Cannot get student with ID");
        }

        return student;
    }
}
