package com.robert.httphelper.converter;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;

import com.alibaba.fastjson.JSON;

public class Json2BeanConverter<T> extends AbstractConverter implements
		ResponseHandler<T> {

	private Class<T> clazz;

	public Json2BeanConverter(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		HttpEntity entity = response.getEntity();
		ContentType contentType = ContentType.getOrDefault(entity);
		if (!contentType.equals(ContentType.APPLICATION_JSON)) {
			throw new ClientProtocolException("Unexpected content type:"
					+ contentType);
		}

		String str = resp2String(response);
		return JSON.parseObject(str, clazz);
	}

}
