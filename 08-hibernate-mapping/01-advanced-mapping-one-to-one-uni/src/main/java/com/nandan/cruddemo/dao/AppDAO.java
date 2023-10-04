package com.nandan.cruddemo.dao;

import com.nandan.cruddemo.entity.Instructor;

public interface AppDAO {

  Void save(Instructor theInstructor);

  Instructor findInstructorById(int theId);

  void deleteInstructorById(int theID);

}
