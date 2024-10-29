package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController //Indica que essa classe é um controlador REST, ou seja, irá expor endpoints que retornarão dados JSON ou XML.
@RequestMapping(value = "/users") //Configura o endpoint base para todos os métodos desta classe como "/users". Assim, qualquer método dentro de UserResource que tiver uma rota será mapeado a partir de "/users".
public class UserResource {
	
	@Autowired // injeção de dependencia
	private UserService service;
	
	@GetMapping //Mapeia o método HTTP GET. Como não há um caminho específico após "/users", esse método responderá às requisições GET para "/users".
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
