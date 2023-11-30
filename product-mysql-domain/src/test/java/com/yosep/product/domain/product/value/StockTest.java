package com.yosep.product.domain.product.value;

import static org.junit.jupiter.api.Assertions.*;

import com.yosep.product.domain.product.error.InvalidStockValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class StockTest {

	private Stock stock;

	@BeforeEach
	private void init() {
		stock = new Stock(
			30L,
			30L
		);
	}

	@Test
	void 재고엔티티_프로퍼티_비교_성공() {
		// Given
		Long total = 30L;
		Long remain = 29L;

		Stock stock = new Stock(
			total,
			remain);

		// When & Then
		assertEquals(total, stock.getTotal());
		assertEquals(remain, stock.getRemain());
	}

	@Test
	void 재고엔티티_increaseTotal_성공() {
		// Given
		Long value = 3L;
		Long total = 33L;
		Long remain = 33L;

		// When
		stock.increaseTotal(value);

		// Then
		assertEquals(total, stock.getTotal());
		assertEquals(remain, stock.getRemain());
	}

	@Test
	void 재고엔티티_increaseRemain_성공() {
		// Given
		Long value = 4L;
		Long remain = 34L;

		// When
		stock.increaseRemain(value);

		// Then
		assertEquals(remain, stock.getRemain());
	}

	@Test
	void 재고엔티티_decreaseTotal_성공() {
		// Given
		Long value = 1L;
		Long remain = 29L;
		Long total = 29L;

		// When
		stock.decreaseTotal(value);

		// Then
		assertEquals(total, stock.getTotal());
		assertEquals(remain, stock.getRemain());
	}

	@Test
	void 재고엔티티_decreaseRemain_성공() {
		// Given
		Long value = 3L;
		Long remain = 27L;

		// When
		stock.decreaseRemain(value);

		// Then
		assertEquals(remain, stock.getRemain());
	}

	@Test
	void 재고엔티티_ensureValidStock_음수일경우_싪패() {
		// Given
		Long value = -1L;
		Stock stock = new Stock(
			30L,
			30L
		);

		// When & Then
		assertThrows(InvalidStockValueException.class, () -> {
			ReflectionTestUtils.invokeMethod(stock, "ensureValidStock", value);
		});
	}

	@Test
	void 재고엔티티_increase_decrease_연산들에서_value가_음수일경우_실패() {
		// Given
		Long value = -1L;

		// When & Then
		assertThrows(InvalidStockValueException.class, () -> stock.increaseTotal(value));
		assertThrows(InvalidStockValueException.class, () -> stock.increaseRemain(value));
		assertThrows(InvalidStockValueException.class, () -> stock.decreaseTotal(value));
		assertThrows(InvalidStockValueException.class, () -> stock.decreaseRemain(value));
	}
}