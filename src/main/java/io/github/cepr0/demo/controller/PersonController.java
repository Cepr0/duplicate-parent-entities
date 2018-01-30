package io.github.cepr0.demo.controller;

import io.github.cepr0.demo.repo.PersonRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cepr0, 2018-01-05
 */
@RequiredArgsConstructor
@RestController
@Transactional
public class PersonController {

	@NonNull private final PersonRepo personRepo;

	@GetMapping("/people")
	public ResponseEntity<?> getAll(@RequestParam(value = "type", required = false, defaultValue = "default") String type) {

		switch (type) {

			default:
				return ResponseEntity.ok(personRepo.findAll());

			case "distinct":
				return ResponseEntity.ok(personRepo.findDistinctBy());

			case "query":
				return ResponseEntity.ok(personRepo.findWithQuery());

			case "distinctQuery":
				return ResponseEntity.ok(personRepo.findDistinctWithQuery());

			case "projection":
				return ResponseEntity.ok(personRepo.findProjectionsBy());

			case "projectionDistinct":
				return ResponseEntity.ok(personRepo.findDistinctProjectionsBy());

			case "projectionQuery":
				return ResponseEntity.ok(personRepo.findProjectionsWithQuery());

			case "projectionDistinctQuery":
				return ResponseEntity.ok(personRepo.findDistinctProjectionsWithQuery());
		}
	}
}
