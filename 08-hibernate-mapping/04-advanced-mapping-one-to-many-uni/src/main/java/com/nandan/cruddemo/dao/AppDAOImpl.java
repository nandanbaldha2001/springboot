package com.nandan.cruddemo.dao;

import com.nandan.cruddemo.entity.Course;
import com.nandan.cruddemo.entity.Instructor;
import com.nandan.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    List<Course> courseList=theInstructor.getCourseList();
    for(Course course:courseList){
      course.setInstructor(null);
    }
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

  @Override
  public List<Course> findCourseByInstructorId(int theId) {
    TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id= :data",Course.class);
    query.setParameter("data",theId);
    List<Course> courseList=query.getResultList();
    return  courseList;
  }

  @Override
  public Instructor findInstructorByIdJoinFetch(int theId) {
    TypedQuery<Instructor> query = entityManager.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courseList " +
            "JOIN FETCH i.instructorDetail WHERE i.id = :data", Instructor.class);

    query.setParameter("data",theId);
    Instructor instructor=query.getSingleResult();
    return  instructor;
  }

  @Override
  @Transactional
  public void updateInstructor(Instructor tempInstructor) {
  entityManager.merge(tempInstructor);
  }

  @Override
  @Transactional
  public void updateCourse(Course tempCourse) {
    entityManager.merge(tempCourse);
  }

  @Override
  public Course findCourseByID(int theId) {
    return entityManager.find(Course.class,theId);
  }

  @Override
  @Transactional
  public void deleteCourseById(int theId) {
    Course tempCourse=entityManager.find(Course.class,theId);
    entityManager.remove(tempCourse);
  }

  @Override
  @Transactional
  public void saveCourse(Course theCourse) {
    entityManager.persist(theCourse);

  }

  @Override
  public Course findCourseAndReviewByCourseId(int theId) {
    TypedQuery<Course> query=entityManager.createQuery(
            "select c from Course c "
            +  " JOIN FETCH c.reviewList "
            + " where c.id= :data ",Course.class
    );
    query.setParameter("data",theId);
    Course course=query.getSingleResult();
    return course;
  }
}
