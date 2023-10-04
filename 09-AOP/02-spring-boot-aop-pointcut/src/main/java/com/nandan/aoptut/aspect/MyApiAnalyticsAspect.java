package com.nandan.aoptut.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyApiAnalyticsAspect {

  @Before("com.nandan.aoptut.aspect.AopEcpression.forDaoPackageNoGatterSatter()")
  public void analyticalApplication(){
    System.out.println("\n we have to run over api first");
  }
}
