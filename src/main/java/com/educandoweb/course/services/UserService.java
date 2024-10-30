package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service // registra a classe como um componente do spring
public class UserService  {
	
	@Autowired //faz a injeção de dependencia de forma transparente
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) { // operação para inserir usuário
		return repository.save(obj);
	}
	
	public void Delete(Long id) {
		repository.deleteById(id);
	}
}