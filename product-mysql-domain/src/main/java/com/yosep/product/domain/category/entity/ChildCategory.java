package com.yosep.product.domain.category.entity;

import com.yosep.product.domain.common.entity.AutoIncPkEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
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
public class ChildCategory extends AutoIncPkEntity {

	@Column(name = "category_name", nullable = false)
	private String categoryName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_cataegory_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private ParentCategory parentCategory;

	@Builder
	public ChildCategory(String categoryName, ParentCategory parentCategory) {
		this.categoryName = categoryName;
		this.parentCategory = parentCategory;
	}
}
