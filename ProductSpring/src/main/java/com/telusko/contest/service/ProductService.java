package com.telusko.contest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.contest.entity.Product;
import com.telusko.contest.repository.ProductDB;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
	@Autowired
	ProductDB db;

	public Product addProduct(Product product) {
		db.save(product);
		return product;
	}

	public List<Product> getAllProducts() {
		return db.findAll();
	}
	
	public List<Product> getProductByName(String name) {
		return db.findByName(name);
	}

	public String deleteProduct(Product prod) {
		// TODO Auto-generated method stub
		db.delete(prod);
		return "Successfully Deleted";
	}
}