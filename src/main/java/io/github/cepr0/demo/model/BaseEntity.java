package io.github.cepr0.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * @author Cepr0, 2018-01-14
 */
@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public class BaseEntity implements Persistable<Integer> {

	@Id
	@GeneratedValue
	private Integer id = null;

	@JsonIgnore
	@Version
	private long version;

	@Override
	public String toString() {
		return "{id=" + id + "}";
	}

	@JsonIgnore
	@Override
	public boolean isNew() {
		return getId() == null;
	}
}
