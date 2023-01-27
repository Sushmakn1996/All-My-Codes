package com.te.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.product.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
