package com.codetips.codetips.controller;

import com.codetips.codetips.controller.request.PersonRequest;
import com.codetips.codetips.entity.Person;
import com.codetips.codetips.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/public/person")
@AllArgsConstructor
public class PersonController {

	private final PersonService service;

	@GetMapping
	public ResponseEntity<List<Person>> list() {
		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> get(@PathVariable Integer id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Person> create(@Valid @RequestBody PersonRequest request) {
		return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Person> update(@PathVariable Integer id,
																			 @Valid @RequestBody PersonRequest request) {
		return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
}
