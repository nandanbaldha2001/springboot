package com.nandan.corespring.rest;

import com.nandan.corespring.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  private Coach coach;
  private Coach secCoach;

  @Autowired
  public  DemoController(@Qualifier("cricketCoach") Coach thisCoach,@Qualifier("cricketCoach") Coach thatCoach){
    coach=thisCoach;
    secCoach=thatCoach;
  }

  @GetMapping("/mydailyworkout")
  public String getMyDailyWorkout(){
    return coach.getDailyWorkout();
  }

  @GetMapping("/check")
  public String check(){
    return "this is for check coach is equal to secCoach : " + (coach==secCoach) ;
  }

}
