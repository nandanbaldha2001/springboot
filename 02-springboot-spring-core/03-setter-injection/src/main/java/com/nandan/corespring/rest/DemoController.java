package com.nandan.corespring.rest;

import com.nandan.corespring.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  private Coach coach;

  @Autowired
  public  void setCoach(Coach thisCoach){
    coach=thisCoach;
  }

  @GetMapping("/mydailyworkout")
  public String getMyDailyWorkout(){
    return coach.getDailyWorkout();
  }

}
