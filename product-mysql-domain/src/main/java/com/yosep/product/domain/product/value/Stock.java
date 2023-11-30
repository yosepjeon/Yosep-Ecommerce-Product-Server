package com.yosep.product.domain.product.value;

import com.yosep.product.domain.product.error.InvalidStockValueException;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

	@Nonnull
	@Column(nullable = false)
	private Long total;

	@Nonnull
	@Column(nullable = false)
	private Long remain;

	public void increaseTotal(Long value) {
		ensureValidStock(value);

		Long nextTotal = total + value;
		Long nextRemain = remain + value;

		ensureValidStock(nextTotal);
		ensureValidStock(nextRemain);

		total = nextTotal;
		remain = nextRemain;
	}

	public void decreaseTotal(Long value) {
		ensureValidStock(value);

		Long nextTotal = total - value;
		Long nextRemain = remain - value;

		ensureValidStock(nextTotal);
		ensureValidStock(nextRemain);

		total = nextTotal;
		remain = nextRemain;
	}

	public void increaseRemain(Long value) {
		ensureValidStock(value);

		Long nextRemain = remain + value;

		ensureValidStock(nextRemain);
		remain = nextRemain;
	}

	public void decreaseRemain(Long value) {
		ensureValidStock(value);

		Long nextRemain = remain - value;

		ensureValidStock(nextRemain);
		remain = nextRemain;
	}

	private void ensureValidStock(Long value) {
		if (value < 1) {
			throw new InvalidStockValueException("value값은 1보다 같거나 커야합니다.");
		}
	}

	// Getters and Setters
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getRemain() {
		return remain;
	}

	public void setRemain(Long remain) {
		this.remain = remain;
	}
}
