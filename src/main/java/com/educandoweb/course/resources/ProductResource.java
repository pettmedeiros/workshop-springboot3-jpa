package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController //Indica que essa classe é um controlador REST, ou seja, irá expor endpoints que retornarão dados JSON ou XML.
@RequestMapping(value = "/products") //Configura o endpoint base para todos os métodos desta classe como "/Products". Assim, qualquer método dentro de ProductResource que tiver uma rota será mapeado a partir de "/Products".
public class ProductResource {
	
	@Autowired // injeção de dependencia
	private ProductService service;
	
	@GetMapping //Mapeia o método HTTP GET. Como não há um caminho específico após "/Products", esse método responderá às requisições GET para "/Products".
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
