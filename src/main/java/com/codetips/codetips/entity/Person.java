package com.codetips.codetips.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "_name")
	@NotNull
	@Size(min = 1, max = 50)
	private String name;

	@Column(name = "_email")
	@Email
	@NotNull
	@Size(min = 1, max = 50)
	private String email;

	@Column(name = "_age")
	@NotNull
	private Integer age;

	@Column(name = "_status")
	@NotNull
	private Boolean status;
}
