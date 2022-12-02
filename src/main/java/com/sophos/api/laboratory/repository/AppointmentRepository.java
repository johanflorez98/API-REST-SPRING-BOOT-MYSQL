package com.sophos.api.laboratory.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sophos.api.laboratory.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	@Query(value = "select * from appointment where id_affiliate = ?1", nativeQuery = true)
	List<Appointment> getbyaffiliate(Long id_affiliate);
	
	@Query(value = "select * from appointment where date = ?1 group by id_affiliate", nativeQuery = true)
	List<Appointment> getbydate(String date);
	
}
