package com.annasblackhat.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.annasblackhat.model.Comment;
import com.annasblackhat.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;
	private List<Comment> list = new ArrayList<>();
	
	public List<Comment> getAll(){
		list.clear();
		repository.findAll().forEach(list::add);
		return list;
	}
	
	public Comment getById(int id){
		return repository.findOne(id);
	}
	
	public List<Comment> getByPostId(int postId){
		list.clear();
		repository.findByPostId(postId).forEach(list::add);
		return list;
	}
	
	public void add(Comment comment){
		repository.save(comment);
	}
	
	public void update(Comment comment){
		repository.save(comment);
	}
	
	public void delete(int id){
		repository.delete(id);
	}
}
