package com.yosep.java.core.error;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class YosepErrorException extends RuntimeException{

	protected String message = "";
}
