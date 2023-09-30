package com.yosep.product.domain.common.vo;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import org.junit.jupiter.api.Test;

/**
 * @author yosep
 * @since 2023-09-31
 */
class MoneyTest {

	@Test
	void eqauls_값이같을때_테스트() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));

		assertEquals(money1, money2);
	}

	@Test
	void eqauls_값이다를때_테스트() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(9999), Currency.getInstance(Locale.US));
		Money money3 = new Money();

		assertNotEquals(money1, money2);
		assertNotEquals(money1, money3);
	}

	@Test
	void multiplyBy_Decimal인자_테스트() {
		BigDecimal expected = BigDecimal.valueOf(300);

		Money money = new Money(100, Currency.getInstance(Locale.KOREA));

		assertEquals(expected.longValue(), money.multiplyBy(BigDecimal.valueOf(3)).getValue().longValue());
	}

	@Test
	void MultiplyBy_double인자_테스트() {
		BigDecimal expected = BigDecimal.valueOf(300);

		Money money = new Money(100, Currency.getInstance(Locale.KOREA));

		assertEquals(expected.longValue(), money.multiplyBy(3.0).getValue().longValue());
	}

	@Test
	void add() {
		BigDecimal expected = BigDecimal.valueOf(300);

		Money money1 = new Money(250);
		money1 = money1.add(new Money(50));

		assertEquals(expected.longValue(), money1.getValue().longValue());

		// 화폐코드가 다를 경우
		Money money2 = new Money(250);
		assertThrows(IllegalArgumentException.class, () -> money2.add(new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.US))));
	}

	@Test
	void subtract() {
		BigDecimal expected = BigDecimal.valueOf(300);

		Money money = new Money(350);
		money = money.subtract(new Money(50));

		// 화폐코드가 다를 경우
		Money money2 = new Money(400);

		assertEquals(expected.longValue(), money.getValue().longValue());
		assertThrows(IllegalArgumentException.class, () -> money2.subtract(new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.US))));
	}

	@Test
	void 화폐코드_같을때_greaterThan() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(9999), Currency.getInstance(Locale.KOREA));

		assertEquals(true, money1.greaterThan(money2));
	}

	@Test
	void 화폐코드_다를때_greaterThan() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(9999), Currency.getInstance(Locale.US));

		assertThrows(IllegalArgumentException.class, () -> money1.greaterThan(money2));
	}

	@Test
	void greaterOrEquals() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(9999), Currency.getInstance(Locale.KOREA));

		assertEquals(true, money1.greaterOrEquals(money2));
		assertEquals(false, money2.greaterOrEquals(money1));
	}

	@Test
	void 화폐코드_다를때_greaterOrEquals() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(9999), Currency.getInstance(Locale.US));

		assertThrows(IllegalArgumentException.class, () -> money1.greaterOrEquals(money2));
	}

	@Test
	void 화폐코드_같을때_lessThan() {
		Money money1 = new Money(BigDecimal.valueOf(9999), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));

		assertEquals(true, money1.lessThan(money2));
	}

	@Test
	void 화폐코드_다를때_lessThan() {
		Money money1 = new Money(BigDecimal.valueOf(9999), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.US));

		assertThrows(IllegalArgumentException.class, () -> money1.lessThan(money2));
	}

	@Test
	void lessOrEquals() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(9999), Currency.getInstance(Locale.KOREA));

		assertEquals(false, money1.lessOrEquals(money2));
		assertEquals(true, money2.lessOrEquals(money1));
	}

	@Test
	void 화폐코드_다를때_lessOrEquals() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));
		Money money2 = new Money(BigDecimal.valueOf(9999), Currency.getInstance(Locale.US));

		assertThrows(IllegalArgumentException.class, () -> money1.lessOrEquals(money2));
	}

	@Test
	void testToString() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));

		assertEquals("Money(value=10000.00, currencyCode=KRW)", money1.toString());
	}

	@Test
	void getValue() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));

		assertEquals(10000, money1.getValue().longValue());
	}

	@Test
	void getCurrencyCode() {
		Money money1 = new Money(BigDecimal.valueOf(10000), Currency.getInstance(Locale.KOREA));

		assertEquals(Currency.getInstance(Locale.KOREA).getCurrencyCode(), money1.getCurrencyCode());
	}
}