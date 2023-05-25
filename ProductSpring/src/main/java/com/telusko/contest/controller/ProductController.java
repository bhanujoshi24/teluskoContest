package com.telusko.contest.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.contest.entity.Product;
import com.telusko.contest.service.ProductService;

import lombok.Getter;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {
		return this.service.getAllProducts();
	}

	@GetMapping("/getProductByName/{name}")
	public List<Product> getProductByName(@PathVariable String name) {
		return this.service.getProductByName(name);
	}

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product prod) {
		return this.service.addProduct(prod);
	}

	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@RequestBody Product product) {
		return this.service.deleteProduct(product);
	}

	@GetMapping("/getProductWithText/{text}")
	public List<Product> getProductWithText(@PathVariable String text) {
		String str = text.toLowerCase();
		List<Product> products = this.service.getAllProducts();
//		List<Product> prods = new ArrayList<>();
//
//		for (Product p : products) {
//			String name = p.getName().toLowerCase();
//			String type = p.getType().toLowerCase();
//			String place = p.getPlace().toLowerCase();
//			if (name.contains(str) || type.contains(str) || place.contains(str))
//				prods.add(p);
//		}
//		return prods;
//		Stream API Code 
		return products.stream().filter(p -> p.getName().toLowerCase().contains(str)
				|| p.getType().toLowerCase().contains(str) || p.getPlace().toLowerCase().contains(str))
				.collect(Collectors.toList());
	}

	@GetMapping("/getProductByPlace/{place}")
	public List<Product> getProductByPlace(@PathVariable String place) {
		List<Product> prodList = new ArrayList<>();
		List<Product> products = this.service.getAllProducts();
		for (Product prd : products) {
			if (prd.getPlace().toLowerCase().equals(place.toLowerCase())) {
				prodList.add(prd);
			}
		}
		return prodList;
	}

	@GetMapping("/getProductOutOfWarrenty")
	public List<Product> getProductOutOfWarrenty() {
		List<Product> products = this.service.getAllProducts();
		int currentYear = Year.now().getValue();
		return products.stream().filter(p -> p.getWarranty() < currentYear).collect(Collectors.toList());
	}
}
