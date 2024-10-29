package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController //Indica que essa classe é um controlador REST, ou seja, irá expor endpoints que retornarão dados JSON ou XML.
@RequestMapping(value = "/categories") //Configura o endpoint base para todos os métodos desta classe como "/Categorys". Assim, qualquer método dentro de CategoryResource que tiver uma rota será mapeado a partir de "/Categorys".
public class CategoryResource {
	
	@Autowired // injeção de dependencia
	private CategoryService service;
	
	@GetMapping //Mapeia o método HTTP GET. Como não há um caminho específico após "/Categorys", esse método responderá às requisições GET para "/Categorys".
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
