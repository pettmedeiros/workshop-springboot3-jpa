package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>  {
	
	//JPARepository possui uma implementação padrão, logo não precisa implementar 
	
}
