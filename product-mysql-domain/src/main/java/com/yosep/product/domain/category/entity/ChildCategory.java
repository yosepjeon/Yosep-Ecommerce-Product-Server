package com.yosep.product.domain.category.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author yosep
 * @since 2023-10-05
 */
@Getter
@Entity
@Table(name = "yosep_product_child_category")
@EqualsAndHashCode(of = {"id", "categoryName"})
@NoArgsConstructor
public class ChildCategory {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "category_name", nullable = false)
	private String categoryName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_cataegory_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private ParentCategory parentCategory;

	@Builder
	public ChildCategory(long id, String categoryName, ParentCategory parentCategory) {
		this.id = id;
		this.categoryName = categoryName;
		this.parentCategory = parentCategory;
	}
}
