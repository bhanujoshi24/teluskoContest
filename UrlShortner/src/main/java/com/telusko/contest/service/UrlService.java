package com.telusko.contest.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.contest.entity.Url;
import com.telusko.contest.repository.UrlRepository;

@Service
public class UrlService {

	@Autowired
	UrlRepository url;

	public List<Url> getAllUrl() {
		return url.findAll();
	}

	public String filterUrl(String oUrl) {
		// TODO Auto-generated method stub
		StringBuilder res = new StringBuilder();
		for (char ele : oUrl.toCharArray()) {
			if (((int) ele > (int) 'a' && (int) ele < (int) 'z') || ((int) ele > (int) 'A' && (int) ele < (int) 'Z'))
				res.append(ele);
		}
		return res.toString();
	}

	public String createUrl(String filterUrl, String originalUrl) {
		// TODO Auto-generated method stub
		List<Url> allUrl = getAllUrl(); // Get All UrlShortner
		Set<String> uniqueSet = new HashSet();
		allUrl.forEach(u -> uniqueSet.add(u.getOutputurl())); // Create Set of Unique Url
		String res = "telus.ko/";
		StringBuilder sb = new StringBuilder();
		while (true) {
			for (int i = 0; i < 6; i++) {
				sb.append(filterUrl.charAt(new Random().nextInt(filterUrl.length())));
			}
			res = res + sb;
			if (!uniqueSet.contains(sb)) { //if generated url is unique break the loop then only
				break;
			}else {
				res = "telus.ko/";
			}
		}
		url.save(new Url(originalUrl, res));
		return res;
	}
}
