package com.example.lesson03.dao;

import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(int id); // 특정 id에 해당하는 row 가져오기
	
	public int insertReview(Review review);
}