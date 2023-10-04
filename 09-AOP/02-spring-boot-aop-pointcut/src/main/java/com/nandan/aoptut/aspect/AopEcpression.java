package com.nandan.aoptut.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopEcpression {
  @Pointcut("execution( * com.nandan.aoptut.dao.*.*(..))")
  public void forDaoPackage(){}

  //pointcut for getter method
  @Pointcut("execution( * com.nandan.aoptut.dao.*.get*(..))")
  public void getter(){}

  //pointcut for setter method
  @Pointcut("execution( * com.nandan.aoptut.dao.*.set*(..))")
  public  void setter(){}

  @Pointcut("forDaoPackage() && !(getter() || setter())")
  public void forDaoPackageNoGatterSatter(){}
}
