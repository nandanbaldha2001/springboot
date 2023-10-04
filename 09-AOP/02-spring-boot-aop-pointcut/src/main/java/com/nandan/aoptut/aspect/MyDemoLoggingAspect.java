package com.nandan.aoptut.aspect;


import com.nandan.aoptut.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {



  //all advices
  //@Before("execution(public void add*())")
  //@Before("execution(public void updateAccount())")
//  @Before("execution( * add*(com.nandan.aoptut.Account))")
  @Before("com.nandan.aoptut.aspect.AopEcpression.forDaoPackageNoGatterSatter()")
  public  void beforeAddAccountAdvice(JoinPoint theJoinPoint){
    System.out.println("\n before addAccount Advice");

    MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
    System.out.println("Method :" + methodSignature);
    Object[] args=theJoinPoint.getArgs();
    for (Object tempArgs:args){
      System.out.println(tempArgs);
      if(tempArgs instanceof Account){
        Account theAccount=(Account) tempArgs;
        System.out.println("Account Name : "+theAccount.getName());
        System.out.println("service name : "+theAccount.getLevel());
      }
    }
  }



}
