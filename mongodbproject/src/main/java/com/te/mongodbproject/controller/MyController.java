package com.te.mongodbproject.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.mongodbproject.dao.StudentRepo;
import com.te.mongodbproject.dto.StudentRequest;
import com.te.mongodbproject.dto.StudentResponse;
import com.te.mongodbproject.entity.Student;

@RestController
public class MyController {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/insert")
	public ResponseEntity<StudentResponse> insertStudent(@RequestBody StudentRequest request) {
		Student map= modelMapper.map(request, Student.class);
		Student insert = this.studentRepo.insert(map);
		System.err.println("inserted");
		return new ResponseEntity<>(new StudentResponse(true, "Added Successfully", insert), HttpStatus.ACCEPTED);
	}

	@PostMapping("/add")
	public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentRequest request) {
		Student map = modelMapper.map(request, Student.class);
		Student save = this.studentRepo.save(map);
		return new ResponseEntity<>(new StudentResponse(true, "Added Successfully", save), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll() {
		List<Student> all = studentRepo.findAll();
		System.err.println(all);
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<Student> findByEmail(String email,int id) {
		Student all = studentRepo.findByEmail(email, id);
		System.err.println(all);
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/findByName")
	public ResponseEntity<List<Student>> findByName(String name) {
		List<Student> all = studentRepo.findByName(name);
		System.err.println(all);
		return ResponseEntity.ok(all);
	}

	@DeleteMapping("/delete")
	public String deleteStudent(@RequestBody StudentRequest id) {
		Student map = modelMapper.map(id, Student.class);
		this.studentRepo.delete(map);
		return "Deleted Successfully";
	}
	
	@DeleteMapping("/deleteById")
	public String deleteStudentById(@RequestBody StudentRequest id) {
		Student map = modelMapper.map(id, Student.class);
		System.err.println("map :"+map);
		studentRepo.deleteById(id,Student.class);
		return "Deleted Successfully";
	}
	
	
}
//		long count = studentRepo.count();
//		System.err.println(count);
//		List<Student> all = studentRepo.findAll();
//		System.err.println(all);
//		studentRepo.deleteAll();
//		System.err.println("deleted all");
