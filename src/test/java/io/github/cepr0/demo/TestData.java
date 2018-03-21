package io.github.cepr0.demo;

import io.github.cepr0.demo.model.Child;
import io.github.cepr0.demo.model.Parent;
import io.github.cepr0.demo.repo.ChildRepo;
import io.github.cepr0.demo.repo.ParentRepo;
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
@Component
public class TestData {

	private final ParentRepo parentRepo;
	private final ChildRepo childRepo;

	public TestData(ParentRepo parentRepo, ChildRepo childRepo) {
		this.parentRepo = parentRepo;
		this.childRepo = childRepo;
	}

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		List<Parent> parents = parentRepo.saveAll(asList(
				new Parent("Parent1"),
				new Parent("Parent2"),
				new Parent("Parent3")
		));

		childRepo.saveAll(asList(
				new Child("Child1", parents.get(0)),
				new Child("Child2", parents.get(1)),
				new Child("Child3", parents.get(1))
		));
	}
}
