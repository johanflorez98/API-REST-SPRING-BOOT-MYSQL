package com.sophos.api.laboratory.model;


import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "Test", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Test implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_test;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	
	public Test() {
		super();
	}

	public Test(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public long getId_test() {
		return id_test;
	}

	public void setId_test(long id_test) {
		this.id_test = id_test;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
