package com.robert.httphelper.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.robert.httphelper.converter.abs.AbstractJsonConverter;

public class Json2ObjectConverter extends AbstractJsonConverter<JSONObject> {

	@Override
	protected JSONObject doConstructObject(String str) {
		return JSON.parseObject(str);
	}

}
