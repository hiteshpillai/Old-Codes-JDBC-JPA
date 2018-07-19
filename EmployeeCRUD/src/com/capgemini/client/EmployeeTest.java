package com.capgemini.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.entities.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee emp = new Employee();
		emp.setEmpName("Hitesh");
		emp.setEmpSal(9211);
		
		em.persist(emp);
		
		System.out.println("Added a row");
		
		Employee ref = em.find(Employee.class, 1);
		System.out.println("id = "+ref.getEmpId());
		System.out.println("Name = "+ref.getEmpName());
		System.out.println("Salary- = "+ref.getEmpSal());
		
		ref.setEmpName("Cathrine");
		ref.setEmpSal(782563);
		
		em.merge(ref);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
}
