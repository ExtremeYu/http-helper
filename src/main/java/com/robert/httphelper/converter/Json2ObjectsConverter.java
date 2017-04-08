package com.robert.httphelper.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.robert.httphelper.converter.abs.AbstractJsonConverter;

/**
 * <p>
 * Convert the http body to JSON object array.
 * </p>
 *
 * @author Robert Lee
 * @version 1.0
 * @since Jul 15, 2015
 */

public class Json2ObjectsConverter extends AbstractJsonConverter<JSONArray> {

	@Override
	protected JSONArray doConstructObject(String str) {
		return JSON.parseArray(str);
	}

}
