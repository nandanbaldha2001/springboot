package com.nandan.corespring.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{
  @Override
  public String getDailyWorkout() {
    return "dp back excersice";
  }
}
