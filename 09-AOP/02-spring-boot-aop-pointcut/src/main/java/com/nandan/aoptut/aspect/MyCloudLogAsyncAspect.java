package com.nandan.aoptut.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {

  @Before("com.nandan.aoptut.aspect.AopEcpression.forDaoPackageNoGatterSatter()")
  public void logToCloudAsyn(){
    System.out.println("\n we have to see cloud thing ");
  }
}
