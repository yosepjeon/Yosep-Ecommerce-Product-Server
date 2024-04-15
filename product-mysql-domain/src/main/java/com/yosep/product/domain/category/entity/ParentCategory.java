package com.yosep.product.domain.category.entity;

import com.yosep.product.domain.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author yosep
 * @since 2023-10-04
 */
@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "yosep_product_parent_category")
@EqualsAndHashCode(callSuper = true, of = {"categoryName"})
public class ParentCategory extends BaseEntity {

	@Column(name = "category_name", nullable = false)
	private String categoryName;
}
