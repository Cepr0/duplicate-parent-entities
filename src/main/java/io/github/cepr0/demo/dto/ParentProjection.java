package io.github.cepr0.demo.dto;

import io.github.cepr0.demo.model.Child;

import java.util.List;

/**
 * @author Cepr0, 2018-01-14
 */
public interface ParentProjection {
	Integer getId();
	String getName();
	List<Child> getChildren();
}
