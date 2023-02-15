package Repo;

import POJO.Student;

import java.util.List;

public interface MyCRUD {

    boolean save(Student student);
    Student getStudentByID(long id);
    List<Student> getStudentByName(String name);

    List<Student> getAllStudent();
}
