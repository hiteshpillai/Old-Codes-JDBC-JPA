package com.capgemini.service;

import java.util.ArrayList;

import com.capgemini.bean.Student;
import com.capgemini.dao.StudentDao;
import com.capgemini.dao.StudentDaoImpl;

public class StudentServiceImpl implements StudentService{

	StudentDao dao;
	
	public StudentServiceImpl(){
		dao = new StudentDaoImpl();
	}

	@Override
	public Student addStudent(Student obj) {
		return dao.addStudent(obj);
	}

	@Override
	public Student deleteStudent(int id) {
		return dao.deleteStudent(id);
	}

	@Override
	public Student updateStudent(Student obj) {
		return dao.updateStudent(obj);
	}

	@Override
	public Student getStudentById(int id) {
		return dao.getStudentById(id);
	}

	@Override
	public ArrayList<Student> getAllStudent() {
		return dao.getAllStudent();
	}
	
	
}
