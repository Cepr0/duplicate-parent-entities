package io.github.cepr0.demo.repo;

import io.github.cepr0.demo.dto.PersonProjection;
import io.github.cepr0.demo.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sergei Poznanski, 2018-01-30
 */
@ActiveProfiles("test")
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepoTest {

	@Autowired private PersonRepo repo;

	@Test // fails: java.lang.AssertionError: Expected size:<2> but was:<4>
	public void findAll() {
		List<Person> people = repo.findAll();
		assertThat(people).hasSize(2);
	}

	@Test // passes
	public void findDistinctBy() {
		List<Person> people = repo.findDistinctBy();
		assertThat(people).hasSize(2);
	}

	@Test // fails: java.lang.AssertionError: Expected size:<2> but was:<4>
	public void findWithQuery() {
		List<Person> people = repo.findWithQuery();
		assertThat(people).hasSize(2);
	}

	@Test // passes
	public void findDistinctWithQuery() {
		List<Person> people = repo.findDistinctWithQuery();
		assertThat(people).hasSize(2);
	}

	@Test // fails: java.lang.AssertionError: Expected size:<2> but was:<4>
	public void findProjectionsBy() {
		List<PersonProjection> people = repo.findProjectionsBy();
		assertThat(people).hasSize(2);
	}

	@Test // passes
	public void findDistinctProjectionsBy() {
		List<PersonProjection> people = repo.findDistinctProjectionsBy();
		assertThat(people).hasSize(2);
	}

	@Test // fails: java.lang.AssertionError: Expected size:<2> but was:<4>
	public void findProjectionsWithQuery() {
		List<PersonProjection> people = repo.findProjectionsWithQuery();
		assertThat(people).hasSize(2);

	}

	@Test // fails: InvalidDataAccessApiUsageException: No aliases found in result tuple!
	public void findDistinctProjectionsWithQuery() {
		List<PersonProjection> people = repo.findDistinctProjectionsWithQuery();
		assertThat(people).hasSize(2);
	}
}