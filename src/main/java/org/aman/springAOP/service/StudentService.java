package org.aman.springAOP.service;

import jdk.jfr.Timestamp;
import org.aman.springAOP.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // target
    // @Timestamp
    public Student createStudent(Student student) {
        System.out.println("Student saved successfully");
        // throw new RuntimeException("Some error occurred");
         return student;
    }

    public String getStudent(String s) {
        System.out.println(s);
        return s;
    }
}
