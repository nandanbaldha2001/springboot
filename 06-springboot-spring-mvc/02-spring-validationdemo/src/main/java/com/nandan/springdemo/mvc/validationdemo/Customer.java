package com.nandan.springdemo.mvc.validationdemo;

import com.nandan.springdemo.mvc.validationdemo.validation.CourseCode;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;

public class Customer {


  private  String firstName;

  @NotNull(message = "is required")
  @Size(min = 1, message = "is required")
  private String lastName;

  @NotNull(message = "is required")
  @Min(value = 0,message = "must be greater then or equal to 0")
  @Max(value = 10,message = "must be less then or equal 10")
  private Integer freePasses;

  @Pattern(regexp = "^[a-bA-Z0-9]{5}",message = "only 5 char/digit")
  private String postalCode;

  @CourseCode(value="tops" ,message = "mustr start with tops")
  private String courseCode;

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public Integer getFreePasses() {
    return freePasses;
  }

  public void setFreePasses(Integer freePasses) {
    this.freePasses = freePasses;
  }

  public String getFirstName() {
    return firstName;
  }



  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
