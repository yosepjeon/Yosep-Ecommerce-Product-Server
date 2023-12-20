package com.yosep.product.domain.category.entity;

import com.yosep.product.domain.common.entity.AutoIncPkEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@EqualsAndHashCode(callSuper = true, of = {"categoryName"})
@NoArgsConstructor
public class ParentCategory extends AutoIncPkEntity {

	@Column(name = "category_name", nullable = false)
	private String categoryName;

	@Builder
	public ParentCategory(String categoryName) {
		this.categoryName = categoryName;
	}
}
