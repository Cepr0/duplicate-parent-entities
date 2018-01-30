package io.github.cepr0.demo.repo;

import io.github.cepr0.demo.model.Car;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Cepr0, 2018-01-14
 */
public interface CarRepo extends JpaRepository<Car, Integer> {
}
