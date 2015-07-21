package com.robert.httphelper;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class Json2ObjectConverter<T> implements ResponseHandler<T> {
	private Class<T> clazz;

	public Json2ObjectConverter(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		StatusLine statusLine = response.getStatusLine();
		HttpEntity entity = response.getEntity();
		if (statusLine.getStatusCode() >= 300) {
			throw new HttpResponseException(statusLine.getStatusCode(),
					statusLine.getReasonPhrase());
		}
		if (entity == null) {
			throw new ClientProtocolException("Response contains no content");
		}

		ContentType contentType = ContentType.getOrDefault(entity);
		if (!contentType.equals(ContentType.APPLICATION_JSON)) {
			throw new ClientProtocolException("Unexpected content type:"
					+ contentType);
		}
		Charset charset = contentType.getCharset();
		if (charset == null) {
			charset = Charset.defaultCharset();
		}

		String str = new String(EntityUtils.toByteArray(entity), charset);
		return JSON.parseObject(str, clazz);
	}
}
