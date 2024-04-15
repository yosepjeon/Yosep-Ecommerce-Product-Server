package com.yosep.product.domain.product.entity;

import com.yosep.product.domain.category.entity.ChildCategory;
import com.yosep.product.domain.category.entity.ParentCategory;
import com.yosep.product.domain.common.entity.BaseEntity;
import com.yosep.product.domain.common.vo.Money;
import com.yosep.product.domain.product.value.Stock;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode(of = {"id"})
@Table(name = "yosep_product")
public class Product extends BaseEntity {

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "seller_id", nullable = false)
	private long sellerId;

	@Column(name = "price", nullable = false)
	private Money price;

	@Embedded
	private Stock stockQuantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_category_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private ParentCategory parentCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "child_category_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private ChildCategory childCategory;

}
