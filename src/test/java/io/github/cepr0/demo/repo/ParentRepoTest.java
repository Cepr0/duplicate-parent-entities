package io.github.cepr0.demo.repo;

import io.github.cepr0.demo.dto.ParentProjection;
import io.github.cepr0.demo.model.Parent;
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
 * @author Cepr0, 2018-01-30
 */
@ActiveProfiles("test")
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentRepoTest {

	@Autowired private ParentRepo repo;

	@Test
	public void findAll() {
		List<Parent> people = repo.findAll();
		assertThat(people).hasSize(3);
	}

	@Test
	public void findDistinctBy() {
		List<Parent> people = repo.findDistinctBy();
		assertThat(people).hasSize(3);
	}

	@Test // fails: Expected size:<3> but was:<4>
	public void findWithQuery() {
		List<Parent> people = repo.findWithQuery();
		assertThat(people).hasSize(3);
	}

	@Test
	public void findDistinctWithQuery() {
		List<Parent> people = repo.findDistinctWithQuery();
		assertThat(people).hasSize(3);
	}

	@Test // fails: Expected size:<2> but was:<4>
	public void findProjectionsBy() {
		List<ParentProjection> people = repo.findProjectionsBy();
		assertThat(people).hasSize(3);
	}

	@Test
	public void findDistinctProjectionsBy() {
		List<ParentProjection> people = repo.findDistinctProjectionsBy();
		assertThat(people).hasSize(3);
	}

	@Test // fails: Expected size:<3> but was:<4>
	public void findProjectionsWithQuery() {
		List<ParentProjection> people = repo.findProjectionsWithQuery();
		assertThat(people).hasSize(3);

	}

	@Test // fails: Expected size:<3> but was:<4>
	public void findDistinctProjectionsWithQuery() {
		List<ParentProjection> people = repo.findDistinctProjectionsWithQuery();
		assertThat(people).hasSize(3);
	}
}