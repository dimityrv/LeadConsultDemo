package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  @PostMapping("/create")
  ResponseEntity<Student> createStudent(@RequestBody StudentDto newStudent) {
    return ResponseEntity.ok(studentService.createStudent(newStudent));
  }

  @GetMapping("/")
  ResponseEntity<List<Student>> getAllStudents() {
    List<Student> students = studentService.findAllStudents();
    if (students.isEmpty()) {
      return null;
    } else {
      return ResponseEntity.ok(students.stream().toList());
    }
  }
  @GetMapping("/findByGroup")
  ResponseEntity<List<Student>> getStudentsByGroup(@RequestBody String universityGroup){

    return ResponseEntity.ok(studentService.findByGroup(universityGroup).stream().toList());
  }
}
