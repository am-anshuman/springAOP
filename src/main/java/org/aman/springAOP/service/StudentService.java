package org.aman.springAOP.service;

import jdk.jfr.Timestamp;
import org.aman.springAOP.annotation.TrackExecutionTime;
import org.aman.springAOP.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 2000,
            operation = "Creating new Student"
    )
    public Student createStudent(Student student) {
        System.out.println("Student saved successfully");
        // throw new RuntimeException("Some error occurred");
         return student;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Getting Student data"
    )
    public String getStudent(String s) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        System.out.println(s);
        return s;
    }
}
