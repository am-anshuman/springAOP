package org.aman.springAOP.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LoggingDecorator implements StudentService {

    private final StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent() {

        // Infra logic
        LoggingServiceUtil.logStart("StudentServiceImpl", "createStudent");

        // Business logic
        studentServiceImpl.createStudent();

        // Infra logic
        LoggingServiceUtil.logEnd("StudentServiceImpl", "createStudent");
    }
}
