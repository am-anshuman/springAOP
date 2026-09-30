package org.aman.springAOP.annotation;

import java.lang.annotation.*;

// marker annotation
/*
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {
}
 */

// configured annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {

    long warnAfter() default 2000;

    String operation() default "";

}
