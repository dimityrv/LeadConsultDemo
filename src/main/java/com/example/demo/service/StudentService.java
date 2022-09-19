package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import java.util.List;

public interface StudentService {

  Student createStudent(StudentDto student);

  List<Student> findAllStudents();

  List<Student> findByGroup(String universityGroup);





}
