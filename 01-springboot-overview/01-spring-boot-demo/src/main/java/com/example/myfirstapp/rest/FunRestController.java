package com.example.myfirstapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

  @GetMapping("/")
  public  String sayHello(){
    return  "hello nandan";
  }
}
