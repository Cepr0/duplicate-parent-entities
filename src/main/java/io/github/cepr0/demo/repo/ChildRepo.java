package io.github.cepr0.demo.repo;

import io.github.cepr0.demo.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Cepr0, 2018-01-14
 */
public interface ChildRepo extends JpaRepository<Child, Integer> {
}
