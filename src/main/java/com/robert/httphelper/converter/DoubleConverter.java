package com.robert.httphelper.converter;

import com.robert.httphelper.converter.abs.AbstractStrConverter;

public class DoubleConverter extends AbstractStrConverter<Double> {

	@Override
	protected Double doConstructObject(String str) {
		return new Double(str);
	}

}
