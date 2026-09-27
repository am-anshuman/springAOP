package org.aman.springAOP.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // target
    public String createStudent() {
        System.out.println("Student saved successfully");
        // throw new RuntimeException("Some error occurred");
         return "Student Saved";
    }
}
