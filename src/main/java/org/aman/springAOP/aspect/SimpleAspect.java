package org.aman.springAOP.aspect;

import org.aman.springAOP.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

    // @Around("@annotation(org.aman.springAOP.annotation.TrackExecutionTime)")
    @Around("@annotation(trackExecutionTime)") // can also be written like this. Name must be same as that of parameter name
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
                                       TrackExecutionTime trackExecutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            String operation = trackExecutionTime.operation();

            if(operation.isBlank()) {
                operation = joinPoint.getSignature().getName();
            }

            long warningThreshold = trackExecutionTime.warnAfter();

            if(duration >= warningThreshold) {
                System.out.println("SLOW OPERATION ALERT: " +
                        "Time taken by " + operation + ": " + duration + "ms");
            } else {
                System.out.println("Time taken by " + operation + ": " + duration + "ms");
            }
        }
    }
}
