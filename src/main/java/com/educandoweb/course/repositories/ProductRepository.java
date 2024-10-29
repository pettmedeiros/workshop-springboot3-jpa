package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {
	
	//JPARepository possui uma implementação padrão, logo não precisa implementar 
	
}
