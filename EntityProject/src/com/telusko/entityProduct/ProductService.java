package com.telusko.entityProduct;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductService {

	List<Product> products = new ArrayList<>();

	public void addProduct(Product p) {
		products.add(p);
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProduct(String name) {
		for (Product p : products) {
			if (p.getName().equals(name))
				return p;
		}

		return null;
	}

	public List<Product> getProductWithText(String text) {
		String str = text.toLowerCase();
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

	public List<Product> getProductByPlace(String place) {
		List<Product> prodList = new ArrayList<>();
		for (Product prd : products) {
			if (prd.getPlace().toLowerCase().equals(place.toLowerCase())) {
				prodList.add(prd);
			}
		}
		return prodList;
	}

	public List<Product> getProductOutOfWarrenty() {
		int currentYear = Year.now().getValue();
		return products.stream().filter(p -> p.getWarranty() < currentYear).collect(Collectors.toList());
	}
}