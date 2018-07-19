package com.capgemini.client;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.bean.Student;
import com.capgemini.service.StudentService;
import com.capgemini.service.StudentServiceImpl;

public class Client {

	public static void main(String[] args) {
		
		int choice = 0;
		StudentService service = new StudentServiceImpl();
		try(Scanner sc = new Scanner(System.in)){
			
			do{
				System.out.println("1. Add Student record\n2. DeleteStudent record\n3. Update Student record\n4. Fetch by ID\n5."
						+ " Get all Student Details.");
				System.out.print("Enter your choice : ");
				choice = sc.nextInt();
				
				switch (choice){
				case 1:{
					System.out.print("\n\nEnter the id : ");
					int id = sc.nextInt();
					System.out.print("Enter name : ");
					String name = sc.next();
					System.out.print("Enter birth year : ");
					int year = sc.nextInt();
					System.out.print("Enter month : ");
					int month = sc.nextInt();
					System.out.print("Enter Date : ");
					int date = sc.nextInt();
					LocalDate bDate = LocalDate.of(year, month, date);
					Student obj = new Student(id, name, bDate);
					System.out.println(obj);
					Student ref = service.addStudent(obj);
					System.out.println("\n\n\nAdded \n" + ref+"\n\n\n\n");
					break;
				}
				
				case 2:{
					System.out.print("Enter the id of the student : ");
					int id = sc.nextInt();
					Student ref = service.deleteStudent(id);
					System.out.println("The student record deleted is : " + ref);
					break;
				}
				
				case 3:{
					System.out.print("Enter the id of the student : ");
					int id = sc.nextInt();
					Student obj = new Student();
					Student ref = service.getStudentById(id);
					System.out.println("The student record to be updated is : " + ref);
					System.out.print("\nEnter new name : ");
					String name = sc.next();
					System.out.print("Enter new birth year : ");
					int year = sc.nextInt();
					System.out.print("Enter new birth month : ");
					int month = sc.nextInt();
					System.out.print("Enter new birth date : ");
					int date = sc.nextInt();
					obj = service.updateStudent(ref);
					break;
				}
				
				case 4:{
					System.out.print("Enter the id of the student : ");
					int id = sc.nextInt();
					Student ref = service.getStudentById(id);
					System.out.println("The student record is : " + ref+"\n\n");
					break;
				}
				}
			}while(true);
		}
		
	}
	
}
