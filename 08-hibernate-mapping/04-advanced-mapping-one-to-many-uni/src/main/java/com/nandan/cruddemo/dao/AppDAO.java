package com.nandan.cruddemo.dao;

import com.nandan.cruddemo.entity.Course;
import com.nandan.cruddemo.entity.Instructor;
import com.nandan.cruddemo.entity.InstructorDetail;
import java.util.List;

public interface AppDAO {

  Void save(Instructor theInstructor);

  Instructor findInstructorById(int theId);

  void deleteInstructorById(int theID);

  InstructorDetail findInstructorDetailById(int theId);

  void deleteInstructorDetailById(int theId);

  List<Course> findCourseByInstructorId(int theId);

  Instructor findInstructorByIdJoinFetch(int theId);

  void updateInstructor(Instructor tempInstructor);

  void updateCourse(Course tempCourse);

  Course findCourseByID(int theId);

  void  deleteCourseById(int theId);

  void saveCourse(Course theCourse);

  Course findCourseAndReviewByCourseId(int theId);
}
