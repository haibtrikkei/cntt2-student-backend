package ra.edu.api.service;

import ra.edu.api.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudentById(Long stuId);
    Student insertStudent(Student student);
    Student updateStudent(Long stuId, Student student);
    boolean deleteStudent(Long stuId);
    List<Student> getStudentsByName(String fullName);
}
