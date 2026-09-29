package org.aman.springAOP.aspect;

import org.aspectj.lang.annotation.Pointcut;

// industry standard
public class ApplicationPointcuts {

    @Pointcut("within(org.aman.springAOP.controller..*)")
    public void controllerLayer() {

    }

    @Pointcut("within(org.aman.springAOP.service..*)")
    public void serviceLayer() {

    }

    @Pointcut("execution(public * * (..)")
    public void publicMethod() {

    }

    @Pointcut("publicMethod() && serviceLayer()")
    public void publicServiceMethod() {

    }
}
