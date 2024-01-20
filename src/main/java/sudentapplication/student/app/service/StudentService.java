package sudentapplication.student.app.service;

import sudentapplication.student.app.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    Student findById(int id);
    Student add(Student theStudent);
    Student delete(int id);
    void deleteAll();
}
