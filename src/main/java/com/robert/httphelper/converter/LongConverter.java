package com.robert.httphelper.converter;

import com.robert.httphelper.converter.abs.AbstractStrConverter;

public class LongConverter extends AbstractStrConverter<Long> {

	@Override
	protected Long doConstructObject(String str) {
		return new Long(str);
	}

}
