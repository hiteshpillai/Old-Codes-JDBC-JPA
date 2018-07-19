package com.capgemini.client;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.entities.Employee;

public class JPQLTest {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		//String qry = "SELECT emp FROM Employee emp WHERE emp.empSal>2000";
		
		String qry = "SELECT emp FROM Employee emp WHERE emp.empName=:enm";
		
		System.out.print("Enter a name to search : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		
		//Query query = em.createQuery(qry);
		
		TypedQuery<Employee> tqry = em.createQuery(qry, Employee.class);
		tqry.setParameter("enm", name);
		List<Employee> list = tqry.getResultList();
		
		for(Employee ref : list){
			//Employee ref = obj;
			System.out.println(ref.getEmpId());
			System.out.println(ref.getEmpName());
			System.out.println(ref.getEmpSal());
			System.out.println();
		}
		
		em.close();
		factory.close();
		
	}
	
}
