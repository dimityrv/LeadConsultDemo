package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentDto {

  private String studentName;
  private String studentAge;
  private String universityGroup;
  private String universityCourses;

}
