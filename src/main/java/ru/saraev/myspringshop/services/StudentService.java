package ru.saraev.myspringshop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.saraev.myspringshop.dto.Student;
import ru.saraev.myspringshop.repositories.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudent(Long id) {
        return studentRepository.getById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    public void addNewStudent(Long id, String name) {
        studentRepository.add(id, name);
    }

    public void addNewStudent(Student student) {
        studentRepository.add(student.getId(), student.getName());
    }
}
