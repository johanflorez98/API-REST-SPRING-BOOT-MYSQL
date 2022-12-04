package com.sophos.api.laboratory.controller;

import java.util.List;
import java.util.Optional;

import com.sophos.api.laboratory.ServiceImp.AffiliateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sophos.api.laboratory.model.Affiliate;

@RestController
@RequestMapping("/api/controller/Affiliate")
public class AffiliateController {
	
	@Autowired
	private AffiliateServiceImp affiliateServiceImp;

	@GetMapping
	public ResponseEntity<List<Affiliate>> getlist() {

		List<Affiliate> affiliate = affiliateServiceImp.getlist();

		if (affiliate.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(affiliate);
		}
	}
	
	@GetMapping(value = "/{affiliateID}")
	public ResponseEntity<Affiliate> getbyid(@PathVariable("affiliateID") Long affiliateID) {

		Optional<Affiliate> optionalAffiliate = affiliateServiceImp.getbyid(affiliateID);

		if (optionalAffiliate.isPresent()) {
			return ResponseEntity.ok(optionalAffiliate.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody Affiliate affiliate) {

		String newAffiliate =  affiliateServiceImp.post(affiliate);

		if (newAffiliate == "Save") {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping(value = "/{affiliateID}")
	public ResponseEntity<Void> delete(@PathVariable("affiliateID") Long affiliateID) {

		String result = affiliateServiceImp.delete(affiliateID);

		if (result == "deleted") {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Affiliate> put(@RequestBody Affiliate affiliate) {
		Optional<Affiliate> optionalAffiliate = affiliateServiceImp.put(affiliate);

		if (optionalAffiliate.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(optionalAffiliate.get());
		}
	}
}

