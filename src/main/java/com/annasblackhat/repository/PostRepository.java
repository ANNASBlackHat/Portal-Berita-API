package com.annasblackhat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.annasblackhat.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
	
	public List<Post> findByCategoryId(int categoryId);
	
}
