package com.sophos.api.laboratory.repository;


import com.sophos.api.laboratory.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

}