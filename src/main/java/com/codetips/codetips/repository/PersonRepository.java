package com.codetips.codetips.repository;

import com.codetips.codetips.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {

	@Query("select p from Person p where p.status = true")
	List<Person> findAll();

	@Query("select p from Person p where p.id = :id and p.status = true")
	Optional<Person> findById(@Param("id") Integer id);
}
