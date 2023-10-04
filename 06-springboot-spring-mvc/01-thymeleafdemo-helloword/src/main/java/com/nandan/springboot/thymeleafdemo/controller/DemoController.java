package com.nandan.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {
  // create mapping for hello


  @GetMapping("/hello")
  public String sayHello(Model theMOdel){
    theMOdel.addAttribute("theDate",new java.util.Date());
    return "helloworld";
  }
}
