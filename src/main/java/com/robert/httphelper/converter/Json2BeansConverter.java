package com.robert.httphelper.converter;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.robert.httphelper.converter.abs.AbstractJsonConverter;

public class Json2BeansConverter<T> extends AbstractJsonConverter<List<T>> {

	private Class<T> clazz;

	public Json2BeansConverter(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	protected List<T> doConstructObject(String str) {
		return JSON.parseArray(str, clazz);
	}

}
