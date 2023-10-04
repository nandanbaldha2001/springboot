package com.nandan.springdemo.mvc.validationdemo.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstarintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
  public  String value()  default "rock";
  public  String message() default "it should be start with rock";

  public Class<?>[] groups() default {};

  public Class<? extends Payload>[] payload() default {};

}
