package com.te.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.springboot.entity.Employee;
import com.te.springboot.entity.LoginDetails;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee register(Employee employee) {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
			EntityManager manager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public Employee login(LoginDetails details) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = entityManagerFactory.createEntityManager();
		Employee employee = manager.find(Employee.class, details.getEmpId());
		if(employee.getPassword().equals(details.getPassword())) {
			return employee;
		}
		
		return null;
	}

}
