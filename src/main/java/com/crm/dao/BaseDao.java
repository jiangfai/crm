package com.crm.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDao <E, K extends Serializable> {

	default void add(E entity) { }
	
	default void delete(E entity) { }
	
	default void update(E entity) { }
	
	default E findById(K id) { return null; }
	
	default List<E> findAll() { return null; }
	
	default List<E> findByPage(int start, int size) { return null; }
	
	
}
