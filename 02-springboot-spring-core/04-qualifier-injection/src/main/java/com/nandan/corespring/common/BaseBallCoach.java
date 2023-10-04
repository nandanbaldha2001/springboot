package com.nandan.corespring.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
  @Override
  public String getDailyWorkout() {
    return "do batting 30 min";
  }
}
