package com.robert.httphelper;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import com.alibaba.fastjson.JSON;

public class Json2BeansConverter<T> extends AbstractConverter implements
		ResponseHandler<List<T>> {

	private Class<T> clazz;

	public Json2BeansConverter(Class<T> clazz) {
		this.clazz = clazz;
	}

	public List<T> handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		String str = resp2String(response);
		return JSON.parseArray(str, clazz);
	}

}
