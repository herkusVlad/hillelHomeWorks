import POJO.*;
import Repo.MyCRUDImpl;
import org.hibernate.Session;

public class RunApplication {
    public static void main(String[] args) {
        MyCRUDImpl myCRUD = new MyCRUDImpl();
        Student studentbyID = myCRUD.getStudentByID(1);
        System.out.println("student by ID : " + studentbyID.getName());
        myCRUD.getStudentByName("Vlad").forEach(e->{
            System.out.println("Get student by name : " + e.getName() +" id : "+e.getId());
        });

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SGroup sGroup = new SGroup().setName("AM");
        session.save(sGroup);
        session.getTransaction().commit();
        HibernateUtil.shutdown();

        Student student = new Student().setName("Mikola").setGroup(sGroup).setStartYear(2022);
        System.out.println("Add new student :" + myCRUD.save(student));

        System.out.println("Get new Student  : " + myCRUD.getStudentByID(2).getName());

    }
}
