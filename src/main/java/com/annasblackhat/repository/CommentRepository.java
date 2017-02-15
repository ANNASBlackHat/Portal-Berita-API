package com.annasblackhat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.annasblackhat.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{

	public List<Comment> findByPostId(int postId);
	
}
