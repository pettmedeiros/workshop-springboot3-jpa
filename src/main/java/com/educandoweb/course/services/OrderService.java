package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service // registra a classe como um componente do spring
public class OrderService {
	
	@Autowired //faz a injeção de dependencia de forma transparente
	private OrderRepository repository;
	
	public List<Order> findAll(){ 
		return repository.findAll();
	}
	
	public Order findById(long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
		
		
	}
	

}
