package com.capgemini.dao;

import java.util.ArrayList;

import com.capgemini.bean.Student;

public interface StudentDao {

	public Student addStudent(Student obj);
	public Student deleteStudent(int id);
	public Student updateStudent(Student obj);
	public Student getStudentById(int id);
	public ArrayList<Student> getAllStudent();
}
