package com.nandan.cruddemo;

import com.nandan.cruddemo.dao.AppDAO;
import com.nandan.cruddemo.entity.Instructor;
import com.nandan.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};


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
		int theID=2;
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
