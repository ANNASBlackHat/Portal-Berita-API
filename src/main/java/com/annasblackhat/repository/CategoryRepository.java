package com.annasblackhat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.annasblackhat.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
