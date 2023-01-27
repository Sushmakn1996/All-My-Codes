package com.te.aws;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyLoadingBean {
	
	public LazyLoadingBean() {
		System.err.println("lazyLoadingBean created");
	}

}
