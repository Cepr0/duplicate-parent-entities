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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Cepr0, 2018-01-05
 */
@Profile("dev")
@RequiredArgsConstructor
@Component
public class DemoData {

	@NonNull private final PersonRepo personRepo;
	@NonNull private final CarRepo carRepo;

	@Async
	@Transactional
	@EventListener
	public void personData(ApplicationReadyEvent event) {
		List<Person> people = personRepo.save(asList(
				Person.of("Person1", "Address1"),
				Person.of("Person2", "Address2"),
				Person.of("Person3", "Address3")
		));

		carRepo.save(asList(
				Car.of("Car1", "Brand1").setPerson(people.get(0)),
				Car.of("Car2", "Brand1").setPerson(people.get(0)),
				Car.of("Car3", "Brand2").setPerson(people.get(1)),
				Car.of("Car4", "Brand2").setPerson(people.get(1)),
				Car.of("Car5", "Brand3").setPerson(people.get(2)),
				Car.of("Car6", "Brand3").setPerson(people.get(2))
		));
	}
}
