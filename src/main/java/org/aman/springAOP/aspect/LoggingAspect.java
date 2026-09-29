package org.aman.springAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // Named Pointcut
//    @Pointcut("within(org.aman.springAOP.service..*) " +
//            "&& " +
//            "execution(public * * (..))")
//    public void logPublicServiceMethod() {
//        // empty body
//    }

    /*
    Different types of Pointcuts:
    1. execution
    2. within
    3. @annotation
    4. bean
    5. args
    6. @args
    7. @within
    8. @target
    9. target
    10. this
    11. @this
     */

    // execution - works at METHOD level
    // @Before("execution(* org.aman.springAOP..*(..))")
    // @Before("execution(* org.aman.springAOP.service.StudentService.*(..))")

    // within - works at CLASS level
    // @Before("within(org.aman.springAOP..*)")
    // @Before("within(org.aman.springAOP.service.StudentService)")

    // @annotation - works at METHOD level
    // @Before("@annotation(jdk.jfr.Timestamp)")

    // bean
    // @Before("bean(studentService) || bean(studentController)")

    // Using Named Pointcut
    // @Before("logPublicServiceMethod()")
    @Before("org.aman.springAOP.aspect.ApplicationPointcuts.publicServiceMethod()") // industry standard
    public void logBeforeMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        System.out.println(className + "." + methodName + " intercepted");
    }
}
