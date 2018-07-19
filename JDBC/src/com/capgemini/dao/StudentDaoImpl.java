package com.capgemini.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.capgemini.bean.Student;
import com.capgemini.util.DBUtil;

public class StudentDaoImpl implements StudentDao{

	Connection con;
	
	public StudentDaoImpl(){
		con = DBUtil.getConnect();
	}
	
	@Override
	public Student addStudent(Student obj) {
		Student ref = null;
		String sql = "INSERT INTO HPSTUDENT VALUES(?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, obj.getStudId());
			pstmt.setString(2, obj.getStudName());
			LocalDate lDate = obj.getbDate();
			java.sql.Date bDate = Date.valueOf(lDate);
			pstmt.setDate(3, bDate);
			
			int row = pstmt.executeUpdate();
			
			if(row > 0){
				System.out.println("Successfully inserted a record.");
				ref = obj;
			}else{
				ref = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ref;
	}

	@Override
	public Student deleteStudent(int id) {
		String sql = "DELETE FROM HPSTUDENT WHERE STUDID=?";
		
		Student ref = null;
		
		
		Student stud = null; 
		ref = this.getStudentById(id);
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int row = pstmt.executeUpdate();
			if (row > 0){
				stud = ref;
			}
			else{
				stud = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return stud;
	}

	@Override
	public Student updateStudent(Student obj) {
		String sql = "UPDATE HPSTUDENT SET STUDNAME=? , BDATE=? WHERE STUDID=?";
		Student ref = new Student();
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.getStudName());
			LocalDate lDate = obj.getbDate();
			java.sql.Date bDate = Date.valueOf(lDate);
			pstmt.setDate(2, bDate);
			pstmt.setInt(3, obj.getStudId());
			
			int row = pstmt.executeUpdate();
		
			if(row > 0){
				System.out.println("Successfully inserted a record.");
				ref = obj;
			}else{
				ref = null;
			}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return ref;
		}

	@Override
	public Student getStudentById(int id) {
		String sql = "SELECT * FROM HPSTUDENT WHERE STUDID=?";
		Student ref = null;
		
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				ref = new Student();
				ref.setStudId(rs.getInt(1));
				ref.setStudName(rs.getString(2));
				java.sql.Date date = (rs.getDate(3));
				ref.setbDate(date.toLocalDate());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ref;
	}

	@Override
	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
