package com.te.mongodbproject.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.te.mongodbproject.dto.StudentRequest;
import com.te.mongodbproject.entity.Student;

public interface StudentRepo extends MongoRepository<Student, Integer> {

//	Student save(StudentRequest request);

	void findById(String name);
	
	void insert(String name);
	
//	@Query("{email:?0}")
	@Query("{$and :[{email:?0},{id:?1}]}")
    Student findByEmail(@Param("email") String email,@Param("id") int id);
	
	@Query(value="{name:?0}",count=true)
	List<Student> findByName(/*@Param("name")*/ String name);

	@Query("{id:?0}")
	void deleteById(StudentRequest id, Class<Student> class1);

	

}
