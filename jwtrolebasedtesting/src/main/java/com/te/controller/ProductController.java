package com.te.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.dto.ProductResponse;
import com.te.message.ConstantStrings;
import com.te.product.Product;
import com.te.repo.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	public ProductRepository repo;

	@GetMapping("/products")
	@RolesAllowed({ "Role_customer", "Role_editor" })
	public List<Product> list() {
		return repo.findAll();
	}

	@PostMapping("/add")
	@Secured("Role_editor")
	public ResponseEntity<ProductResponse> create(@RequestBody Product product) {
		Product save = repo.save(product);
		return new ResponseEntity<ProductResponse>(new ProductResponse(true, ConstantStrings.DATASUCCESS, save),
				HttpStatus.ACCEPTED);
	}

}
