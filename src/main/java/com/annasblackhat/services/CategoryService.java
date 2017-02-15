package com.annasblackhat.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annasblackhat.model.Category;
import com.annasblackhat.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	public List<Category> getAll(){
		List<Category> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}
	
	public Category getById(int id){
		return repository.findOne(id);
	}
	
	public void add(Category category){
		repository.save(category);
	}
	
	public void update(Category category){
		repository.save(category);
	}
	
	public void delete(int id){
		repository.delete(id);
	}
}
