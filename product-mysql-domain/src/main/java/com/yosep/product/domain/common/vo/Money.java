package com.yosep.product.domain.common.vo;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author yosep
 * @since 2023-09-30
 */
@Getter
@ToString
@Embeddable
@EqualsAndHashCode
public class Money implements Serializable {

	public static final Currency DEFAULT_CURRENCY = Currency.getInstance(Locale.KOREA);

	public static final Money ZERO = new Money(BigDecimal.ZERO);

	private BigDecimal value;

	private String currencyCode;

	protected Money() {
		value = BigDecimal.ZERO;
		currencyCode = DEFAULT_CURRENCY.getCurrencyCode();
	}

	public Money(BigDecimal value, Currency currency) {
		this(value, currency.getCurrencyCode());
	}

	private Money(BigDecimal value, String currencyCode) {
		this.value = value.setScale(2, RoundingMode.HALF_EVEN);
		this.currencyCode = currencyCode;
	}

	public Money(BigDecimal value) {
		this(value, DEFAULT_CURRENCY);
	}

	public Money(double value, Currency currency) {
		this(BigDecimal.valueOf(value), currency.getCurrencyCode());
	}

	public Money(double value) {
		this(value, DEFAULT_CURRENCY);
	}

	public Money multiplyBy(double multiplier) {
		return multiplyBy(BigDecimal.valueOf(multiplier));
	}

	public Money multiplyBy(BigDecimal multiplier) {
		return new Money(value.multiply(multiplier), currencyCode);
	}

	public Money add(Money money) {
		if (!compatibleCurrency(money)) {
			throw new IllegalArgumentException("Currency mismatch");
		}

		return new Money(value.add(money.value), determineCurrencyCode(money));
	}

	public Money subtract(Money money) {
		if (!compatibleCurrency(money))
			throw new IllegalArgumentException("Currency mismatch");

		return new Money(value.subtract(money.value), determineCurrencyCode(money));
	}

	/**
	 * Currency is compatible if the same or either money object has zero value.
	 */
	private boolean compatibleCurrency(Money money) {
		return isZero(value) || isZero(money.value) || currencyCode.equals(money.getCurrencyCode());
	}

	private boolean isZero(BigDecimal testedValue) {
		return BigDecimal.ZERO.compareTo(testedValue) == 0;
	}

	/**
	 * @return currency from this object or otherCurrencyCode. Preferred is the
	 *         one that comes from Money that has non-zero value.
	 */
	private Currency determineCurrencyCode(Money otherMoney) {
		String resultingCurrenctCode = isZero(value) ? otherMoney.currencyCode : currencyCode;
		return Currency.getInstance(resultingCurrenctCode);
	}

	public boolean greaterThan(Money other) {
		if (!compatibleCurrency(other)) {
			throw new IllegalArgumentException("Currency mismatch");
		}

		return value.compareTo(other.value) > 0;
	}

	public boolean greaterOrEquals(Money other) {
		if (!compatibleCurrency(other)) {
			throw new IllegalArgumentException("Currency mismatch");
		}

		return value.compareTo(other.value) >= 0;
	}

	public boolean lessThan(Money other) {
		if (!compatibleCurrency(other)) {
			throw new IllegalArgumentException("Currency mismatch");
		}

		return value.compareTo(other.value) < 0;
	}

	public boolean lessOrEquals(Money other) {
		if (!compatibleCurrency(other)) {
			throw new IllegalArgumentException("Currency mismatch");
		}

		return value.compareTo(other.value) <= 0;
	}
}
