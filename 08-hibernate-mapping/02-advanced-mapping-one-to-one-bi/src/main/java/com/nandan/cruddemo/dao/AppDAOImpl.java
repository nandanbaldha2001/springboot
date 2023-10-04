package com.nandan.cruddemo.dao;

import com.nandan.cruddemo.entity.Instructor;
import com.nandan.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements  AppDAO{

  private EntityManager entityManager;


  @Autowired
  public AppDAOImpl(EntityManager entityManager){
    this.entityManager=entityManager;
  }
  @Override
  @Transactional
  public Void save(Instructor theInstructor) {
    entityManager.persist(theInstructor);
    return null;
  }

  @Override
  public Instructor findInstructorById(int theId) {
    Instructor theInstructor=entityManager.find(Instructor.class,theId);
    return theInstructor;
  }

  @Override
  @Transactional
  public void deleteInstructorById(int theID) {
    Instructor theInstructor=entityManager.find(Instructor.class,theID);
    entityManager.remove(theInstructor);


  }

  @Override
  public InstructorDetail findInstructorDetailById(int theId) {
    return entityManager.find(InstructorDetail.class,theId);
  }

  @Override
  @Transactional
  public void deleteInstructorDetailById(int theId) {
    InstructorDetail theDetails=entityManager.find(InstructorDetail.class,theId);
    theDetails.getInstructor().setInstructorDetail(null);
    entityManager.remove(theDetails);
  }
}
