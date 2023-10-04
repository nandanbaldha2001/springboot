package com.nandan.corespring.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
  public  BaseBallCoach(){
    System.out.println("in a constructor : "+getClass().getSimpleName());
  }
  @Override
  public String getDailyWorkout() {
    return "do batting 30 min";
  }
}
