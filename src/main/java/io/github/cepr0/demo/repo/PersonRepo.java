package io.github.cepr0.demo.repo;

import io.github.cepr0.demo.dto.PersonProjection;
import io.github.cepr0.demo.model.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Cepr0, 2018-01-03
 */
public interface PersonRepo extends JpaRepository<Person, Integer> {

	@EntityGraph(attributePaths = "cars")
	@Override
	List<Person> findAll();

	@EntityGraph(attributePaths = "cars")
	List<Person> findDistinctBy();

	@Query("select p from Person p left join fetch p.cars")
	List<Person> findWithQuery();

	@Query("select distinct p from Person p left join fetch p.cars")
	List<Person> findDistinctWithQuery();

	@EntityGraph(attributePaths = "cars")
	List<PersonProjection> findProjectionsBy();

	@EntityGraph(attributePaths = "cars")
	List<PersonProjection> findDistinctProjectionsBy();

	@Query("select p from Person p left join fetch p.cars")
	List<PersonProjection> findProjectionsWithQuery();

	@Query("select distinct p from Person p left join fetch p.cars")
	List<PersonProjection> findDistinctProjectionsWithQuery();
}
