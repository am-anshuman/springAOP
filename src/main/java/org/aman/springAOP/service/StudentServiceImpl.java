package org.aman.springAOP.service;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public void createStudent() {
        System.out.println("Student saved successfully");
    }
}
