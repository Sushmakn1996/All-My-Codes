package com.te.service;

import com.te.dto.EmpDto;
import com.te.dto.LoginDto;

public interface EmpService {
	
	public EmpDto register(EmpDto empDto);

	public EmpDto login(LoginDto loginDto);

	public EmpDto update(EmpDto empDto);

	public Boolean delete(String empId);

}
