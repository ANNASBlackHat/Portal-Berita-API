package com.annasblackhat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.annasblackhat.model.Category;
import com.annasblackhat.services.CategoryService;

@RestController
@RequestMapping("news_portal/api/category")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@RequestMapping("")
	public List<Category> getAll(){
		return service.getAll();
	}
	
	@RequestMapping("/{categoryId}")
	public Category getById(@PathVariable int categoryId){
		return service.getById(categoryId);
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public void addCategory(@RequestParam String name){
		service.add(new Category(name));
	}
	
	@RequestMapping(value="", method = RequestMethod.PUT)
	public void update(@RequestParam int id, @RequestParam String name){
		service.update(new Category(id, name));
	}
	
	@RequestMapping(value="/{categoryId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int categoryId){
		service.delete(categoryId);
	}
	
}
