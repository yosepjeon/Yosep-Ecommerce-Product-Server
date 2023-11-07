package com.yosep.product.domain.product.entity;

import com.yosep.product.domain.category.entity.ChildCategory;
import com.yosep.product.domain.common.vo.Money;
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
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author yosep
 * @since 2023-10-04
 */
@Getter
@Entity
@Table(name = "yosep_product")
@NoArgsConstructor
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "seller_id", nullable = false)
	private String sellerId;

	@Column(name = "price", nullable = false)
	private Money price;

	@Column(name = "quantity", nullable = false)
	private int stockQuantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "child_category_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private ChildCategory childCategory;
}
