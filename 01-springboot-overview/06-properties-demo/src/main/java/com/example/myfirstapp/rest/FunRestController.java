package com.example.myfirstapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

  @Value("${coach.name}")
  private String coachName;
  @Value("${team.name}")
  private  String teamName;
  @GetMapping("/")
  public  String sayHello(){
    return  "hello nandan";
  }
  @GetMapping("/workout")
  public String getDailyWorkout(){
    return "daily workout done";
  }

  @GetMapping("/fortune")
  public String getDailyFortune(){
    return "it's a daily fortune";
  }

  @GetMapping("/teaminfo")
  public String getTeamInfo(){
    return "coach name : "+coachName+"  teamName : "+teamName;
  }
}
