package com.example.demo.repository;

import com.example.demo.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  Optional<Student> findByStudentName(String name);

  @Query(value = "SELECT * FROM university.student as s WHERE university_group = ?1", nativeQuery = true)
  List<Student> getStudentsByStudentCourse(String universityGroup);


}
