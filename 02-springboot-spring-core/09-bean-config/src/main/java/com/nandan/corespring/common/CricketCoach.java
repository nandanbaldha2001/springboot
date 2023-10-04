package com.nandan.corespring.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
  public  CricketCoach(){
    System.out.println("in a constructor : "+getClass().getSimpleName());
  }
  @Override
  public String getDailyWorkout() {
    return "practice fast bollwing 15 miniutes";
  }
}
