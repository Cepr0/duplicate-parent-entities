package io.github.cepr0.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Cepr0, 2018-01-03
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Parent extends BaseEntity {

	private String name;

	@OneToMany(mappedBy = "parent")
	private List<Child> children;

	public Parent(String name) {
		this.name = name;
	}
}
