package com.codetips.codetips.service.impl;

import com.codetips.codetips.controller.request.PersonRequest;
import com.codetips.codetips.entity.Person;
import com.codetips.codetips.repository.PersonRepository;
import com.codetips.codetips.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository repository;

	private Person init(PersonRequest request) {
		Person person = new Person();
		person.setName(request.getName());
		person.setEmail(request.getEmail());
		person.setAge(request.getAge());
		person.setStatus(Boolean.TRUE);

		return person;
	}

	@Override
	public List<Person> list() {
		return repository.findAll();
	}

	@Override
	public Person get(Integer id) {
		Optional<Person> person = repository.findById(id);
		if (!person.isPresent()) {
			log.info("No existe la persona con ID [ " + id + " ]");
			throw new RuntimeException("No existe la persona con ID [ " + id + " ]");
		}
		return person.get();
	}

	@Override
	public Person create(PersonRequest request) {
		Person person = init(request);
		return repository.save(person);
	}

	@Override
	public Person update(Integer id, PersonRequest request) {
		Person person = get(id);
		person.setName(request.getName());
		person.setEmail(request.getEmail());
		person.setAge(request.getAge());

		return repository.save(person);
	}

	@Override
	public String delete(Integer id) {
		Person person = get(id);
		person.setStatus(Boolean.FALSE);
		repository.save(person);

		return "OK";
	}
}
