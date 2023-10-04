package com.nandan.cruddemo;

import com.nandan.cruddemo.dao.AppDAO;
import com.nandan.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createCourseAndStudent(appDAO);
			//findCourseAndStudentByCourseID(appDAO);
			//findCourseAndStudentByStudentId(appDAO);
			addMoreCoursesForStudents(appDAO);

		};


	}

	private void addMoreCoursesForStudents(AppDAO appDAO) {
		int theId=2;
		Student tempStudent=appDAO.findStudentAndCourseByStudentId(theId);
		Course tempCourse=new Course("spring");
		tempStudent.addCourse(tempCourse);
		appDAO.updateStudent(tempStudent);
	}

	private void findCourseAndStudentByStudentId(AppDAO appDAO) {
		int theId=2;
		Student tempStudent=appDAO.findStudentAndCourseByStudentId(theId);
		System.out.println(tempStudent);
		System.out.println(tempStudent.getCourseList());
	}

	private void findCourseAndStudentByCourseID(AppDAO appDAO) {
		int theId=10;
		Course tempCourse=appDAO.findCourseAndStudentByCourseId(theId);
		System.out.println("displaying course  :  "+ tempCourse);
		System.out.println("displaying students  : "+tempCourse.getStudentList());
	}

	private void createCourseAndStudent(AppDAO appDAO) {
				Course tempCourse=new Course("data definition");
				Student temps1=new Student("nandan","baldha","test1@gmail.com");
		Student temps2=new Student("nandan","baldha","test1@gmail.com");
		Student temps3=new Student("nandan","baldha","test1@gmail.com");
		tempCourse.addStudent(temps1);
		tempCourse.addStudent(temps2);
		tempCourse.addStudent(temps3);
		appDAO.saveCourse(tempCourse);

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		appDAO.deleteCourseById(theId);
	}

	private void retriveCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		System.out.println("starting");
		Course theCourse=appDAO.findCourseAndReviewByCourseId(theId);
		System.out.println(theCourse);
		System.out.println(theCourse.getReviewList());
		System.out.println("done");
	}

	private void createCourseAndReview(AppDAO appDAO) {
		Course tempCourse=new Course("data analytics");
		tempCourse.addReview(new Review("great nice "));
		tempCourse.addReview(new Review(" nice "));
		tempCourse.addReview(new Review(" nice great"));
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviewList());
		appDAO.saveCourse(tempCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theID=10;
		System.out.println("starting");
		appDAO.deleteCourseById(theID);
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;
		Course tempCourse=appDAO.findCourseByID(theId);
		System.out.println(tempCourse);
		tempCourse.setTitle("rdbms1");
		appDAO.updateCourse(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		tempInstructor.setLastName("patel");
		appDAO.updateInstructor(tempInstructor);
	}

	private void findInstructorWithCoursesWithFetch(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructoe id :" + theId);
		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor : "+tempInstructor);
		System.out.println("associated courses : "+tempInstructor.getCourseList());
		System.out.println("done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("finding instructor with id "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("instructor : "+tempInstructor);
		//find course for instructor
		System.out.println("finding courses for instructor id : "+theId);
		List<Course> courses=appDAO.findCourseByInstructorId(theId);
		tempInstructor.setCourseList(courses);
		System.out.println(tempInstructor.getCourseList());
		System.out.println("done");


	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theID=1;
		System.out.println("finding instructor with id "+theID);
		Instructor tempInstructor=appDAO.findInstructorById(theID);
		System.out.println("instructor : "+tempInstructor);
		System.out.println("courses  : "+tempInstructor.getCourseList());
		System.out.println("done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor("jiya","baldha","baldhajiya@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("www.demo3.com","singing");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("adding instructor"+ tempInstructor);
		Course tempCourse1=new Course("dbms");
		Course tempCourse2=new Course("java");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourseList());
		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theID=4;
		System.out.println("deleting details of id : " + theID);
		appDAO.deleteInstructorDetailById(theID);
		System.out.println("deleted details of id : " + theID);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=3;
		InstructorDetail tempInstructor=appDAO.findInstructorDetailById(theId);
		System.out.println(tempInstructor.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theID=1;
		System.out.println("deleteing instructor which id is:"+theID);
		appDAO.deleteInstructorById(theID);
		System.out.println("deleted");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=2;
		System.out.println("finding the id : "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor  : "+tempInstructor.toString());
		System.out.println("associate details of tempInstructor : "+tempInstructor.getInstructorDetail());

	}

	private void  createInstructor(AppDAO appDAO){
//		Instructor tempInstructor=new Instructor("nandan","baldha","baldhanandan@gmail.com");
//		InstructorDetail tempInstructorDetail=new InstructorDetail("www.demo.com","cricket");

		Instructor tempInstructor=new Instructor("bhumi","baldha","baldhabhumi@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("www.demo2.com","nothing");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("adding instructor"+ tempInstructor);
		appDAO.save(tempInstructor);
	}


}
