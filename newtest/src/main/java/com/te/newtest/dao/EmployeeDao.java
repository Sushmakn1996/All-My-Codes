package com.te.newtest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.newtest.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
