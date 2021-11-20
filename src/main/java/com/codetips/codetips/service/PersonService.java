package com.codetips.codetips.service;

import com.codetips.codetips.controller.request.PersonRequest;
import com.codetips.codetips.entity.Person;

import java.util.List;

public interface PersonService {

	List<Person> list();
	Person get(Integer id);
	Person create(PersonRequest request);
	Person update(Integer id, PersonRequest request);
	String delete(Integer id);
}
