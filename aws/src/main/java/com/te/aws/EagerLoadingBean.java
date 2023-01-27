package com.te.aws;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping
public class EagerLoadingBean {
	
	final String a;

	public EagerLoadingBean() {
		this.a = "book";
		System.err.println("eagerLoadingBean created "+a);
	}
	
	
	

}
