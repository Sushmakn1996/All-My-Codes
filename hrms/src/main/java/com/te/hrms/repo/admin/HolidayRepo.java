package com.te.hrms.repo.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.hrms.entity.admin.Holidays;

@Repository
public interface HolidayRepo extends JpaRepository<Holidays, Integer> {

	
}
