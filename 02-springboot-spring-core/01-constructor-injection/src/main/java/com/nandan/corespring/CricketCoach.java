package com.nandan.corespring;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{
  @Override
  public String getDailyWorkout() {
    return "practice fast bollwing 15 miniutes";
  }
}
