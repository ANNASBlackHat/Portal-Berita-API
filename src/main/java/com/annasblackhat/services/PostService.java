package com.annasblackhat.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.annasblackhat.model.Post;
import com.annasblackhat.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	private List<Post> list = new ArrayList<>();
	
	public List<Post> getAll(){
		list.clear();
		repository.findAll().forEach(list::add);
		return list;
	}
	
	public Post getById(int id){
		return repository.findOne(id);
	}
	
	public List<Post> getByCategory(int categoryId){
		list.clear();
		repository.findByCategoryId(categoryId).forEach(list::add);;
		return list;
	}
	
	public void add(Post post){
		repository.save(post);
	}
	
	public void update(Post post){
		repository.save(post);
	}
	
	public void delete(int id){
		repository.delete(id);
	}
	
}
