package com.annasblackhat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.annasblackhat.model.Comment;
import com.annasblackhat.model.Post;
import com.annasblackhat.services.CommentService;

@RestController
@RequestMapping("news_portal/api/comment")
public class CommentController {

	@Autowired
	private CommentService service;
	
	@RequestMapping("")
	public List<Comment> getAll(){
		return service.getAll();
	}
	
	@RequestMapping("/{id}")
	public Comment getById(@PathVariable int id){
		return service.getById(id);
	}
	
	@RequestMapping("/post/{postId}")
	public List<Comment> getByPostId(@PathVariable int postId){
		return service.getByPostId(postId);
	}
	
	@RequestMapping(value="/{postId}", method = RequestMethod.POST)
	public void add(@PathVariable int postId ,@RequestBody Comment comment){
		comment.setPost(new Post(postId));
		service.add(comment);
	}
	
	@RequestMapping(value="", method = RequestMethod.PUT)
	public void update(Comment comment){
		service.update(comment);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id){
		service.delete(id);
	}
}
