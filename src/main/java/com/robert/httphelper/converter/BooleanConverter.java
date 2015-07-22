package com.robert.httphelper.converter;

import com.robert.httphelper.converter.abs.AbstractStrConverter;

public class BooleanConverter extends AbstractStrConverter<Boolean> {

	@Override
	protected Boolean doConstructObject(String str) {
		return new Boolean(str);
	}

}
