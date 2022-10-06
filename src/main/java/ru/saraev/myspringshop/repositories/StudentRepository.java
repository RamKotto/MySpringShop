package ru.saraev.myspringshop.repositories;

import org.springframework.stereotype.Repository;
import ru.saraev.myspringshop.dto.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {

    private List<Student> students;

    @PostConstruct
    public void init() {
        this.students = new ArrayList<>(Arrays.asList(
                new Student(1L, "Milk"),
                new Student(2L, "Bread"),
                new Student(3L, "Potato"),
                new Student(4L, "Onion"),
                new Student(5L, "Sugar")
        ));
    }

    public List<Student> getAll() {
        return students;
    }

    public Student getById(Long id) {
        return students.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
