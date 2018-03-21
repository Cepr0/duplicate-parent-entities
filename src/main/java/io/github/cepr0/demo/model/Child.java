package io.github.cepr0.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

/**
 * @author Cepr0, 2018-01-13
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Child extends BaseEntity {

	private String name;

	@ManyToOne(fetch = LAZY)
	private Parent parent;

	public Child(String name, Parent parent) {
		this.name = name;
		this.parent = parent;
	}
}
