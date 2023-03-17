package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;
@Component("studentDao")
public class StudentDaoImp implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		//insert query
		String query="insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	//update 
	@Override
	public int update(Student student) {
		String query="update student set name=?,city=? where id=?";
		int result = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;
	}
	//delete 
	@Override
	public int delete(int studentId) {
		String q="delete from student where id=? ";
		int r = this.jdbcTemplate.update(q,studentId);
		return r;
	}

	//read single student
	@Override
	public Student getStudent(int studentId) {
		//Fetching single data
		String q="select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(q, rowMapper,studentId);
		return student;
	}
	//read All students
	@Override
	public List<Student> getAllStudens() {
		String q="select * from student";
		List<Student> std = this.jdbcTemplate.query(q, new RowMapperImpl());
		return std;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
}
