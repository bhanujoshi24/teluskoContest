package com.telusko.contest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.contest.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer>{

}
