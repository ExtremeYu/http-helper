package com.robert.httphelper.converter;

import java.math.BigDecimal;

import com.robert.httphelper.converter.abs.AbstractStrConverter;

public class BigDecimalConverter extends AbstractStrConverter<BigDecimal> {

	@Override
	protected BigDecimal doConstructObject(String str) {
		return new BigDecimal(str);
	}

}
