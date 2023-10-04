package com.nandan.corespring.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
  @Override
  public String getDailyWorkout() {
    return "Do Sprint";
  }
}
