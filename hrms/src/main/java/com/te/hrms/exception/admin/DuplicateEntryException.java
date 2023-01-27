package com.te.hrms.exception.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class DuplicateEntryException extends RuntimeException {

	private String message;

}
