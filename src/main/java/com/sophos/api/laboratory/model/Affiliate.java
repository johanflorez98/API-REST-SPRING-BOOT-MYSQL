package com.sophos.api.laboratory.model;


import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "Affiliate", uniqueConstraints = {@UniqueConstraint(columnNames = {"mail"})})
public class Affiliate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_affiliate;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String mail;
	
	public Affiliate() {
		super();
	}

	public Affiliate(String name, int age, String mail) {
		super();
		this.name = name;
		this.age = age;
		this.mail = mail;
	}

	public long getId_affiliate() {
		return id_affiliate;
	}

	public void setId_affiliate(long id_affiliate) {
		this.id_affiliate = id_affiliate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}	
	
}

