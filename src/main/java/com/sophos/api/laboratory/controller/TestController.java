package com.sophos.api.laboratory.controller;


import java.util.List;
import java.util.Optional;

import com.sophos.api.laboratory.ServiceImp.TestServiceImp;
import com.sophos.api.laboratory.model.Test;
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


@RestController
@RequestMapping("/api/Test/")
public class TestController {
	
	@Autowired
	private TestServiceImp testServiceImp;
	
	@GetMapping
	public ResponseEntity<List<Test>> getlist() {
		
		List<Test> tests = testServiceImp.getlist();

		if (tests.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(tests);
		}
	}
	
	@RequestMapping(value = "{testID}")
	public ResponseEntity<Test> getbyid(@PathVariable("testID") Long testID) {

			Optional<Test> optionalTest = testServiceImp.getbyid(testID);

			if (optionalTest.isPresent()) {
				return ResponseEntity.ok(optionalTest.get());
			} else {
				return ResponseEntity.notFound().build();
			}
	}
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody Test test) {

		String newTest =  testServiceImp.post(test);

		if (newTest == "Save") {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping(value = "{testID}")
	public ResponseEntity<Void> delete(@PathVariable("testID") Long testID) {

		String result = testServiceImp.delete(testID);
		if (result == "deleted") {

			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Test> put(@RequestBody Test test) {
		Optional<Test> optionalTest = testServiceImp.put(test);

		if (optionalTest.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(optionalTest.get());
		}
	}

}