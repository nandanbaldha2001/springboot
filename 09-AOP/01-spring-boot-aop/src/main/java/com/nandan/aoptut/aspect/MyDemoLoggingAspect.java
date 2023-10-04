package com.nandan.aoptut.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

  //all advices
  //@Before("execution(public void add*())")
  //@Before("execution(public void updateAccount())")
//  @Before("execution( * add*(com.nandan.aoptut.Account))")
  @Before("execution( * com.nandan.aoptut.dao.*.*(..))")
  public  void beforeAddAccountAdvice(){
    System.out.println("\n before addAccount Advice");
  }
}
