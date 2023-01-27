package com.te.manytomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.te.manytomany.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
