package sudentapplication.student.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sudentapplication.student.app.entity.Student;
import sudentapplication.student.app.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {

        Optional<Student> theStudent = studentRepository.findById(id);

        if(theStudent.isEmpty()){
            throw new RuntimeException("Student does not exist");
        }
        else{
            return theStudent.get();
        }
    }

    @Override
    public Student add(Student theStudent) {

        return studentRepository.save(theStudent);
    }

    @Override
    public Student delete(int id) {

        Optional<Student> theStudent = studentRepository.findById(id);

        if(theStudent.isEmpty()){
            throw new RuntimeException("Student does not exist");
        }

        studentRepository.delete(theStudent.get());
        return theStudent.get();
    }

    @Override
    public void deleteAll() {

        studentRepository.deleteAll();
    }

}
