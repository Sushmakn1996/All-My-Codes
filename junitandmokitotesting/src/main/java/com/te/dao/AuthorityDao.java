package com.te.dao;

import org.springframework.data.repository.CrudRepository;


import com.te.entity.Authority;

public interface AuthorityDao extends CrudRepository<Authority, String> {
	public Authority findByName(String name);

}
