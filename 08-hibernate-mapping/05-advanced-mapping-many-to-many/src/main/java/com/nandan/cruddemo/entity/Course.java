package com.nandan.cruddemo.entity;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "title")
  private  String title;

  @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
  @JoinColumn(name = "instructor_id")
  private  Instructor instructor;


  @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id")
  private List<Review> reviewList;



  @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
  @JoinTable(
          name = "course_student",
          joinColumns  = @JoinColumn(name="course_id"),
          inverseJoinColumns =@JoinColumn(name="student_id")
  )
  private List<Student> studentList;

  public Course(){

  }

  public Course(String title) {
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  public List<Review> getReviewList() {
    return reviewList;
  }

  public void setReviewList(List<Review> reviewList) {
    this.reviewList = reviewList;
  }
 public void addReview(Review theReview){
    if(reviewList==null){
      reviewList=new ArrayList<>();
    }
    reviewList.add(theReview);
 }
  @Override
  public String toString() {
    return "Course{" +
            "id=" + id +
            ", title='" + title + '\'' +
            '}';
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }
  public  void addStudent(Student theStudent){
    if(studentList==null){
      studentList=new ArrayList<>();
    }
    studentList.add(theStudent);
  }
}
