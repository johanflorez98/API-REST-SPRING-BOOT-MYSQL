package com.sophos.api.laboratory.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import org.hibernate.action.internal.OrphanRemovalAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Appointment")
public class Appointment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private	 LocalDate date;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm")
	private LocalTime hour;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn (name="id_affiliate", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Affiliate affiliate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn (name="id_test", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Test test;

	public Appointment() {
		super();
	}

	public Appointment(LocalDate date, LocalTime hour, Affiliate affiliate, Test test) {
		super();
		this.date = date;
		this.hour = hour;
		this.affiliate = affiliate;
		this.test = test;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public Affiliate getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(Affiliate affiliate) {
		this.affiliate = affiliate;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
}
