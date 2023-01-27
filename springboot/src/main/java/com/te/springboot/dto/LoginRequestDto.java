package com.te.springboot.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

	private String userName;
	private String password;
	private LocalDateTime localDateTime = LocalDateTime.now();

}
