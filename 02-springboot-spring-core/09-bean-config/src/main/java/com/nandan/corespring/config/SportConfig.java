package com.nandan.corespring.config;

import com.nandan.corespring.common.Coach;
import com.nandan.corespring.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

  @Bean("aquatic")
  public Coach swimCoach(){
    return new SwimCoach();
  }
}
