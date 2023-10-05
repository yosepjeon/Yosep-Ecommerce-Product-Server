package com.yosep.product.domain.category.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author yosep
 * @since 2023-10-04
 */
@Getter
@Entity
@Table(name = "yosep_product_parent_category")
@EqualsAndHashCode(of = {"id", "categoryName"})
@NoArgsConstructor
public class ParentCategory {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "category_name", nullable = false)
	private String categoryName;

	@Builder
	public ParentCategory(long id, String categoryName) {
		this.id = id;
		this.categoryName = categoryName;
	}
}
