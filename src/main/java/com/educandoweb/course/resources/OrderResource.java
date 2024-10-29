package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController //Indica que essa classe é um controlador REST, ou seja, irá expor endpoints que retornarão dados JSON ou XML.
@RequestMapping(value = "/orders") //Configura o endpoint base para todos os métodos desta classe como "/orders". Assim, qualquer método dentro de UserResource que tiver uma rota será mapeado a partir de "/orders".
public class OrderResource {
	
	@Autowired // injeção de dependencia
	private OrderService service;
	
	@GetMapping //Mapeia o método HTTP GET. Como não há um caminho específico após "/orders", esse método responderá às requisições GET para "/orders".
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
