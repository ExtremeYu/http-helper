package com.robert.httphelper.converter;

import com.alibaba.fastjson.JSON;
import com.robert.httphelper.converter.abs.AbstractJsonConverter;

public class Json2BeanConverter<T> extends AbstractJsonConverter<T> {

	private Class<T> clazz;

	public Json2BeanConverter(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	protected T doConstructObject(String str) {
		return JSON.parseObject(str, clazz);
	}

}
