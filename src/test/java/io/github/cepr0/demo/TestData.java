package io.github.cepr0.demo;

import io.github.cepr0.demo.model.Car;
import io.github.cepr0.demo.model.Person;
import io.github.cepr0.demo.repo.CarRepo;
import io.github.cepr0.demo.repo.PersonRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cepr0, 2018-01-05
 */
@Profile("test")
@RequiredArgsConstructor
@Component
public class TestData {

	@NonNull private final PersonRepo personRepo;
	@NonNull private final CarRepo carRepo;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		List<Person> people = personRepo.save(asList(
				Person.of("TestPerson1", "TestAddress1"),
				Person.of("TestPerson2", "TestAddress2")
		));

		carRepo.save(asList(
				Car.of("TestCar1", "TestBrand1").setPerson(people.get(0)),
				Car.of("TestCar2", "TestBrand2").setPerson(people.get(0)),
				Car.of("TestCar3", "TestBrand1").setPerson(people.get(1)),
				Car.of("TestCar4", "TestBrand2").setPerson(people.get(1))
		));
	}
}
