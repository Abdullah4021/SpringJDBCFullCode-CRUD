package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("project is started");
		// jdbcTemplate
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//		// insert data
//		Student std = new Student();
//		std.setId(666);
//		std.setName("Mohd Kamil");
//		std.setCity("Khalilabad");
//		int result = studentDao.insert(std);
//		System.out.println("no of rows affected" + result);

//		 //update data
//		Student s=new Student();
//		s.setId(550);
//		s.setName("Mohd Adil");
//		s.setCity("SakiNaka");
//		int result = studentDao.update(s);
//		System.out.println("updated rows are "+ result);
//		
//		//delete data
//		int r = studentDao.delete(666);
//		System.out.println("effected rows are: "+r);
//	
//		//read single data
//		Student student = studentDao.getStudent(550);
//		System.out.println(student);
		
		//read all Students
		List<Student> studens = studentDao.getAllStudens();
		for(Student s:studens) {
			System.out.println(s);
		}
	}

}
