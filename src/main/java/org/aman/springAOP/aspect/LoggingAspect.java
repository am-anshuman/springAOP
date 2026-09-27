package org.aman.springAOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // proxy
    @Before(
            "execution(" +
            "String " +
            "org.aman.springAOP.service.StudentService.createStudent())"
    )
    public void logBeforeMethod() {
        System.out.println("Student is going to be saved");
    }

    @AfterReturning(
            value = "execution(" +
            "String " +
            "org.aman.springAOP.service.StudentService.createStudent())",
            returning = "result"
    )
    public void logAfterReturningMethod(String result) {
        String s = "Target method returned: " + result;

        System.out.println(s);
    }

    @AfterThrowing(
            value = "execution(* org.aman.springAOP.service.StudentService.createStudent(..))",
            throwing = "exception"
    )
    public void logAfterThrowingMethod(Throwable exception) {
        System.out.println("Exception type: " + exception.getClass().getSimpleName());
        System.out.println("Exception message: " + exception.getMessage());
    }

    @After(
            value = "execution(* org.aman.springAOP.service.StudentService.createStudent(..))"
    )
    public void logAfterMethod() {
        System.out.println("logAfterMethod executed");
    }

    @Around(
            value = "execution(* org.aman.springAOP.service.StudentService.createStudent(..))"
    )
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Starting: " + joinPoint.getSignature().getName());

        try {
            Object result = joinPoint.proceed();

            System.out.println("Execution successful");

            return result;
        } catch (Exception e) {
            System.out.println("Execution failed: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Execution completed");
        }
    }
}
