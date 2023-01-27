package com.te.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.dao.EmpDao;
import com.te.dto.EmpDto;
import com.te.dto.LoginDto;
import com.te.entity.Employee;
import com.te.exception.EmployeeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDao empDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmpDto register(EmpDto empDto) {
		Employee map;
		try {
			System.err.println("try block");
			map = modelMapper.map(empDto, Employee.class);
		} catch (Exception e) {
			throw new EmployeeException("not able to map from dto to entity");
		}
		log.info("map is : {}",map);
		Employee save;
		try {
			System.err.println("save try");
			save = empDao.save(map);
		} catch (Exception e) {
			throw new EmployeeException("not able to save entity in database");
		}
		log.info("save is : {}",save);
		System.err.println("return dto");
		return modelMapper.map(save, EmpDto.class);
	}

	@Override
	public EmpDto login(LoginDto loginDto) {

		Employee findByEmpId = empDao.findByEmpId(loginDto.getEmpId());
		if (findByEmpId != null) {
			if (findByEmpId.getEmpPwd().equals(loginDto.getEmpPwd())) {
				return modelMapper.map(findByEmpId, EmpDto.class);
			}else {
				throw new EmployeeException("password is wrong");
			}
		}
		return null;
	}

	@Override
	public EmpDto update(EmpDto empDto) {
		Employee findByEmpId = empDao.findByEmpId(empDto.getEmpId());
		if (findByEmpId != null) {
			Employee map = modelMapper.map(empDto, Employee.class);
			Employee save = empDao.save(map);
			return modelMapper.map(save, EmpDto.class);
		}
		return null;
	}

	@Override
	public Boolean delete(String empId) {
		Employee findByEmpId = empDao.findByEmpId(empId);
		if (findByEmpId != null) {
			empDao.deleteById(empId);
			return true;
		}
		return false;
	}

}
