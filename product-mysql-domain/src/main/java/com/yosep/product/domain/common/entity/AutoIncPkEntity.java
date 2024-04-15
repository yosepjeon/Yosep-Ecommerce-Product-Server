package com.yosep.product.domain.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AutoIncPkEntity implements Persistable<Long> {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return id == null || id != 0L;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}

		if (!(other instanceof HibernateProxy) && !this.getClass().equals(other.getClass())) {
			return false;
		}

		return id == getIdentifier(other);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	protected Serializable getIdentifier(Object obj) {
		if (obj instanceof HibernateProxy) {
			return (Serializable) ((HibernateProxy) obj).getHibernateLazyInitializer().getIdentifier();
		} else {
			return ((AutoIncPkEntity) obj).getId();
		}
	}
}
