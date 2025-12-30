package com.example.demo.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by id
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    // Add student
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student ref) {
        return studentService.addStudent(ref);
    }

    // Delete student
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student ref = studentService.getStudentById(id);
        if (ref != null) {
            studentService.deleteStudent(ref);
            return "Student deleted successfully";
        }
        return "Student with id " + id + " not found";
    }

    // Update student
    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student ref) {
        Student existing = studentService.getStudentById(ref.getId());
        if (existing != null) {
            existing.setName(ref.getName());
            existing.setEmail(ref.getEmail());
            existing.setCourse(ref.getCourse());
            existing.setFees(ref.getFees());
            return studentService.addStudent(existing);
        }
        return null;
    }
}
