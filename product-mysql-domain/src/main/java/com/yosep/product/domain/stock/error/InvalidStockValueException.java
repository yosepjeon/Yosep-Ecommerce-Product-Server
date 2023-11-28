package com.yosep.product.domain.stock.error;

import com.yosep.java.core.error.YosepErrorException;

public class InvalidStockValueException extends YosepErrorException {

	public InvalidStockValueException(String message) {
		super(message);
	}
}
