package io.github.cepr0.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

/**
 * @author Cepr0, 2018-01-03
 */
@NoArgsConstructor(force = true)
@RequiredArgsConstructor(staticName = "of")
@Getter
@Setter
@Entity
public class Person extends BaseEntity {

	private final String name;
	private final String address;

	@JsonIgnoreProperties("person")
	@OneToMany(mappedBy = "person")
	private final List<Car> cars = new ArrayList<>();
}
