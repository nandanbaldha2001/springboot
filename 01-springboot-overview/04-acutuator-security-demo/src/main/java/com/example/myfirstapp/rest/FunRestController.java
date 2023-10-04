package com.example.myfirstapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

  @GetMapping("/")
  public  String sayHello(){
    return  "hello nandan";
  }
  @GetMapping("workout")
  public String getDailyWorkout(){
    return "daily workout done";
  }

  @GetMapping("fortune")
  public String getDailyFortune(){
    return "it's a daily fortune";
  }
}
