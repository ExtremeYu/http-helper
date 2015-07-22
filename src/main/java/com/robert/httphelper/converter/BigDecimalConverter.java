package com.robert.httphelper.converter;

import java.math.BigDecimal;

import com.robert.httphelper.converter.abs.AbstractStrConverter;

/**
 * <p>
 * Convert the http body to BigDecimal object.
 * </p>
 *
 * @author Robert Lee
 * @version 1.0
 * @since Jul 15, 2015
 */
public class BigDecimalConverter extends AbstractStrConverter<BigDecimal> {

	@Override
	protected BigDecimal doConstructObject(String str) {
		return new BigDecimal(str);
	}

}
