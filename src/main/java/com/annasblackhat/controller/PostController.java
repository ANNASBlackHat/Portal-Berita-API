package com.annasblackhat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.annasblackhat.model.Category;
import com.annasblackhat.model.Post;
import com.annasblackhat.services.PostService;

@RestController
@RequestMapping("news_portal/api/post")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@RequestMapping("")
	public List<Post> getAll(){
		return service.getAll();
	}
	
	@RequestMapping("/{postId}")
	public Post getById(@PathVariable("postId") int id){
		return service.getById(id);
	}
	
	@RequestMapping("/category/{categoryId}")
	public List<Post> getByCategoryId(@PathVariable int categoryId){
		return service.getByCategory(categoryId);
	}
	
	@RequestMapping(value="/{categoryId}", method=RequestMethod.POST)
	public void add(@PathVariable int  categoryId, @RequestBody Post post){
		post.setCategory(new Category(categoryId, null));
		service.add(post);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public void update(@RequestBody Post post){
		service.update(post);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable int id){
		service.delete(id);
	}
	
}
