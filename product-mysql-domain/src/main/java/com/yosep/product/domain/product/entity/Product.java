package com.yosep.product.domain.product.entity;

import com.yosep.product.domain.category.entity.ChildCategory;
import com.yosep.product.domain.category.entity.ParentCategory;
import com.yosep.product.domain.common.entity.AutoIncPkEntity;
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
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@AllArgsConstructor
public class Product extends AutoIncPkEntity {

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

	@Column(name = "delete_check")
	private boolean isDeleted = false;

	@Column(name = "insert_operator", updatable = false)
	protected String insertOperator;

	@Column(name = "update_operator")
	protected String updateOperator;

	@Column(name = "insert_time", updatable = false)
	protected LocalDateTime insertTime;

	@Column(name = "update_time")
	protected LocalDateTime updateTime;

	@Column(name = "delete_time")
	protected LocalDateTime deleteTime;

	@Builder
	public Product(String productName, long sellerId, Money price, Stock stockQuantity,
		ChildCategory childCategory, boolean isDeleted,
		String insertOperator, String updateOperator, LocalDateTime insertTime,
		LocalDateTime updateTime, LocalDateTime deleteTime) {
		this.productName = productName;
		this.sellerId = sellerId;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.parentCategory = childCategory.getParentCategory();
		this.childCategory = childCategory;
		this.isDeleted = isDeleted;
		this.insertOperator = insertOperator;
		this.updateOperator = updateOperator;
		this.insertTime = insertTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
	}
}
