package com.telusko.contest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.contest.entity.Product;


@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {

	public List<Product> findByName(String name);
}
