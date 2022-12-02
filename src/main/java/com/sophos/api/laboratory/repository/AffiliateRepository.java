package com.sophos.api.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sophos.api.laboratory.model.Affiliate;

public interface AffiliateRepository extends JpaRepository<Affiliate, Long> {

}
