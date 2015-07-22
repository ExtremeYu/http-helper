package com.robert.httphelper.converter;

import com.robert.httphelper.converter.abs.AbstractStrConverter;

/**
 * <p>
 * Convert the http body to Boolean object.
 * </p>
 *
 * @author Robert Lee
 * @version 1.0
 * @since Jul 15, 2015
 */

public class BooleanConverter extends AbstractStrConverter<Boolean> {

	@Override
	protected Boolean doConstructObject(String str) {
		return new Boolean(str);
	}

}
