package sudentapplication.student.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import sudentapplication.student.app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
