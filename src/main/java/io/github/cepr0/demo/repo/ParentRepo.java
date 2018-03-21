package io.github.cepr0.demo.repo;

import io.github.cepr0.demo.dto.ParentProjection;
import io.github.cepr0.demo.model.Parent;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Cepr0, 2018-01-03
 */
public interface ParentRepo extends JpaRepository<Parent, Integer> {

	@EntityGraph(attributePaths = "children")
	@Override
	List<Parent> findAll();

	@EntityGraph(attributePaths = "children")
	List<Parent> findDistinctBy();

	@Query("select p from Parent p left join fetch p.children")
	List<Parent> findWithQuery();

	@Query("select distinct p from Parent p left join fetch p.children")
	List<Parent> findDistinctWithQuery();

	@EntityGraph(attributePaths = "children")
	List<ParentProjection> findProjectionsBy();

	@EntityGraph(attributePaths = "children")
	List<ParentProjection> findDistinctProjectionsBy();

	@Query("select p from Parent p left join fetch p.children")
	List<ParentProjection> findProjectionsWithQuery();

	@Query("select distinct p from Parent p left join fetch p.children")
	List<ParentProjection> findDistinctProjectionsWithQuery();
}
