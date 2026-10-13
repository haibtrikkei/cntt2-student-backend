package ra.edu.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.api.model.entity.Student;
import ra.edu.api.repository.StudentRepository;
import ra.edu.api.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long stuId) {
        return studentRepository.findById(stuId).orElseThrow(()-> new NoSuchElementException("Không tồn tại sinh viên "+stuId));
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long stuId, Student student) {
        studentRepository.findById(stuId).orElseThrow(()-> new NoSuchElementException("Không tồn tại sinh viên "+stuId));
        student.setStuId(stuId);
        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudent(Long stuId) {
        studentRepository.findById(stuId).orElseThrow(()-> new NoSuchElementException("Không tồn tại sinh viên "+stuId));
        studentRepository.deleteById(stuId);
        return true;
    }

    @Override
    public List<Student> getStudentsByName(String fullName) {
        return studentRepository.getStudentsByFullNameContaining(fullName);
    }
}
