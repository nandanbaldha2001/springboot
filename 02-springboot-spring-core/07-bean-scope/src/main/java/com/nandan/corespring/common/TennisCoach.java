package com.nandan.corespring.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{
  public  TennisCoach(){
    System.out.println("in a constructor : "+getClass().getSimpleName());
  }
  @Override
  public String getDailyWorkout() {
    return "dp back excersice";
  }
}
