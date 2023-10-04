package com.nandan.cruddemo;

import com.nandan.cruddemo.dao.StudentDao;
import com.nandan.cruddemo.entity.Student;
//import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner->{
			multipleStudent(studentDao);
			//readStudent(studentDao);
			//queryforStudent(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);

			//deleteAllStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDao studentDao) {
		System.out.println("deleting all studnet");
		int n=studentDao.deleteAll();
		System.out.println("number of student deleted ");

	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId=3;
		studentDao.delete(studentId);


	}

	private void updateStudent(StudentDao studentDao) {
		int studentId=2;
		Student st=studentDao.findById(studentId);
		st.setLastName("yash");
		studentDao.update(st);
	}

	private void queryforStudent(StudentDao studentDao) {
		List<Student> st= (List<Student>) studentDao.findByLastName("baldha");
		for(Student s:st){
			System.out.println(s);
		}
	}

	private void readStudent(StudentDao studentDao) {
		int a=1;
		System.out.println("finding studebt");
		Student st=studentDao.findById(1);
		System.out.println("found");
		System.out.println(st.toString());
	}

		private void cretaeStudent(StudentDao studentDao) {
		System.out.println("creating student");
		Student st=new Student("nandna","baldha","nandan.beyond@square");
		System.out.println("saving studnet");
		studentDao.save(st);
		System.out.println("info student"+st.getId());

	}
	private void multipleStudent(StudentDao studentDao){
		System.out.println("creating multiple id");
		Student st=new Student("bhumi","baldha","nandan.beyond@square");
		Student st2=new Student("raj","kaneria","nandan.beyond@square");
		Student st3=new Student("wong","ring","nandan.beyond@square");
		System.out.println("saving students");
		studentDao.save(st);
		studentDao.save(st2);
		studentDao.save(st3);
		System.out.println("getting studnet info");
		System.out.println(st.getId()+"  "+st2.getId()+"   "+ st3.getId());

	}

}
