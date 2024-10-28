package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController //Indica que essa classe é um controlador REST, ou seja, irá expor endpoints que retornarão dados JSON ou XML.
@RequestMapping(value = "/users") //Configura o endpoint base para todos os métodos desta classe como "/users". Assim, qualquer método dentro de UserResource que tiver uma rota será mapeado a partir de "/users".
public class UserResource {
	
	@GetMapping //Mapeia o método HTTP GET. Como não há um caminho específico após "/users", esse método responderá às requisições GET para "/users".
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		
		return ResponseEntity.ok().body(u);
		
		
	}
	

}
