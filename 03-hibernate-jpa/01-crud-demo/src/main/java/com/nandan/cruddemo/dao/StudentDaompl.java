package com.nandan.cruddemo.dao;

import com.nandan.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDaompl implements StudentDao {
  private EntityManager entityManager;

  @Autowired
  public StudentDaompl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Student theStudent) {
        entityManager.persist(theStudent);
  }

  @Override
  public Student findById(int id) {
    return entityManager.find(Student.class , id);
  }

  @Override
  public List<Student> allStudent() {
    TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);
    return query.getResultList();
  }

  @Override
  public List<Student> findByLastName(String lastName) {
    TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
    query.setParameter("theData",lastName);
    return query.getResultList();
  }

  @Override
  @Transactional
  public void update(Student theStudent) {
          entityManager.merge(theStudent);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    Student st=entityManager.find(Student.class,id);
    entityManager.remove(st);
    System.out.println("student deleted");
  }

  @Override
  @Transactional
  public int deleteAll() {
    int numRowDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
    return numRowDeleted;
  }
}
