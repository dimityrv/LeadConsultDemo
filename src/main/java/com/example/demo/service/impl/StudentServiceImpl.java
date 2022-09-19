package com.example.demo.service.impl;

import com.example.demo.dto.StudentDto;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final ModelMapper modelMapper = new ModelMapper();

  @Override
  public Student createStudent(StudentDto newStudent) {
    Student student = modelMapper.map(newStudent,Student.class);
    Optional<Student> optionalStudent = studentRepository.findByStudentName(newStudent.getStudentName());
    if (optionalStudent.isPresent()){
      throw new StudentNotFoundException("Student with such name already exist.");
    }
    studentRepository.save(student);
    return student;
  }

  @Override
  public List<Student> findAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  public List<Student> findByGroup(String universityGroup) {
    return studentRepository.getStudentsByStudentCourse(universityGroup);
  }
}
