package com.robert.httphelper.converter;

import com.robert.httphelper.converter.abs.AbstractStrConverter;

public class IntConverter extends AbstractStrConverter<Integer> {

	@Override
	protected Integer doConstructObject(String str) {
		return new Integer(str);
	}

}
