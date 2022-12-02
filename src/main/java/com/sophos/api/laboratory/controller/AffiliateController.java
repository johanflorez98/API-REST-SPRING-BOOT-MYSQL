package com.sophos.api.laboratory.controller;

import java.util.List;
import java.util.Optional;

import com.sophos.api.laboratory.Service.AffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.api.laboratory.model.Affiliate;

@RestController
@RequestMapping("/api/Affiliate/")
public class AffiliateController {
	
	@Autowired
	private AffiliateService affiliateService;
	
	@GetMapping
	public ResponseEntity<List<Affiliate>> getlist() {

		List<Affiliate> affiliate = affiliateService.getlist();

		if (affiliate.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(affiliate);
		}
	}
	
	@RequestMapping(value = "{affiliateID}")
	public ResponseEntity<Affiliate> getbyid(@PathVariable("affiliateID") Long affiliateID) {

		Optional<Affiliate> optionalAffiliate = affiliateService.getbyid(affiliateID);

		if (optionalAffiliate.isPresent()) {
			return ResponseEntity.ok(optionalAffiliate.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody Affiliate affiliate) {

		String newAffiliate =  affiliateService.post(affiliate);

		if (newAffiliate == "Save") {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping(value = "{affiliateID}")
	public ResponseEntity<Void> delete(@PathVariable("affiliateID") Long affiliateID) {

		String result = affiliateService.delete(affiliateID);

		if (result == "deleted") {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Affiliate> put(@RequestBody Affiliate affiliate) {
		Optional<Affiliate> optionalAffiliate = affiliateService.put(affiliate);

		if (optionalAffiliate.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(optionalAffiliate.get());
		}
	}
}

