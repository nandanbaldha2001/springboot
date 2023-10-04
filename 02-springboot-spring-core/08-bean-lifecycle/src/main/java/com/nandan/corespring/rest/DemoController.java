package com.nandan.corespring.rest;

import com.nandan.corespring.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  private Coach coach;


  @Autowired
  public  DemoController(@Qualifier("cricketCoach") Coach thisCoach){
    coach=thisCoach;

  }
  @PostConstruct
  public void postConstruct(){
    System.out.println("this is after construct"+getClass().getSimpleName());
  }

  @PreDestroy
  public void cleanUpStuff(){
    System.out.println("cleanup  "+getClass().getSimpleName());
  }
  @GetMapping("/mydailyworkout")
  public String getMyDailyWorkout(){
    return coach.getDailyWorkout();
  }



}
