package com.nandan.cruddemo.dao;

import com.nandan.cruddemo.entity.Instructor;
import com.nandan.cruddemo.entity.InstructorDetail;

public interface AppDAO {

  Void save(Instructor theInstructor);

  Instructor findInstructorById(int theId);

  void deleteInstructorById(int theID);

  InstructorDetail findInstructorDetailById(int theId);

  void deleteInstructorDetailById(int theId);

}
