package com.robert.httphelper.converter;

import com.robert.httphelper.converter.abs.AbstractStrConverter;

/**
 * <p>
 * Convert the http body to double object.
 * </p>
 *
 * @author Robert Lee
 * @version 1.0
 * @since Jul 15, 2015
 */

public class DoubleConverter extends AbstractStrConverter<Double> {

	@Override
	protected Double doConstructObject(String str) {
		return new Double(str);
	}

}
