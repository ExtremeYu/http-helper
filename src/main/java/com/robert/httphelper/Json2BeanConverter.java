package com.robert.httphelper;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import com.alibaba.fastjson.JSON;

public class Json2BeanConverter<T> extends AbstractConverter implements
		ResponseHandler<T> {

	private Class<T> clazz;

	public Json2BeanConverter(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		String str = resp2String(response);
		return JSON.parseObject(str, clazz);
	}

}
