package com.example.student_backend.controller;

import com.example.student_backend.model.Student;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/students")
public class StudentController {
    @GetMapping
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(
                new Student(1L, "Alice", 21, 88)
        );

        students.add(
                new Student(2L, "Bob", 22, 75)
        );

        students.add(
                new Student(3L, "Jack", 20, 55)
        );

        return students;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        return student;
    }
}
