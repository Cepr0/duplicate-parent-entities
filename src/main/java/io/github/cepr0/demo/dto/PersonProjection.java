package io.github.cepr0.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.cepr0.demo.model.Car;

import java.util.List;

/**
 * @author Cepr0, 2018-01-14
 */
public interface PersonProjection {
	Integer getId();
	String getName();
	String getAddress();
	@JsonIgnoreProperties("person") List<Car> getCars();
}
