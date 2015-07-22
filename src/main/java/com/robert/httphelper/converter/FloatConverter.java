package com.robert.httphelper.converter;

import com.robert.httphelper.converter.abs.AbstractStrConverter;

public class FloatConverter extends AbstractStrConverter<Float> {

	@Override
	protected Float doConstructObject(String str) {
		return new Float(str);
	}

}
