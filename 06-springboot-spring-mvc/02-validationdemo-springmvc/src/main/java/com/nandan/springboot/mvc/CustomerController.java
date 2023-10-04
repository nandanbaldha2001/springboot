package com.nandan.springboot.mvc;

import jakarta.validation.Valid;
import org.jboss.logging.BasicLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.SslConfigurationValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

  @GetMapping("/")
  public  String customerForm(Model theModel){
    theModel.addAttribute("customer",new Customer());
    return "customer-form";

  }
  @PostMapping("/processForm")
  public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){

    System.out.println(theCustomer.toString());
    if(theBindingResult.hasErrors()){
      return "customer-form";
    }
    else{
      return "customer-confirmation";
    }
  }
}
