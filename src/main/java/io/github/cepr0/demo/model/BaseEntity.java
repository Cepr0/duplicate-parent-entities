package io.github.cepr0.demo.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * @author Cepr0, 2018-01-14
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id @GeneratedValue private Integer id;
	@Version private long version;

	@Override
	public String toString() {
		return "{id=" + id + "}";
	}
}
