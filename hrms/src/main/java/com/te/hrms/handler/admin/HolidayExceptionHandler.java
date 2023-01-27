package com.te.hrms.handler.admin;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.hrms.exception.admin.DuplicateEntryException;

@RestControllerAdvice
public class HolidayExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<?> duplicateEntry(DuplicateEntryException e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<?> duplicateEntrySql(SQLException e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}
