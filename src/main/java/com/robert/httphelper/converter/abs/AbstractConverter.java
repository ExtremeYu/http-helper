package com.robert.httphelper.converter.abs;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;

/**
 * <p>
 * The abstract class to convert the HTTP body to some specified type. This is a
 * template callback design pattern.
 * </p>
 *
 * @author Robert Lee
 * @version 1.0
 * @since Jul 15, 2015
 */

public abstract class AbstractConverter<T> implements ResponseHandler<T> {
	public T handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		checkFormat(response);

		return doConvert(response);
	}

	protected abstract void checkFormat(HttpResponse response)
			throws ClientProtocolException;

	protected abstract T doConvert(HttpResponse response)
			throws HttpResponseException, ClientProtocolException, IOException;

	protected Charset getCharset(HttpResponse response)
			throws ClientProtocolException {
		HttpEntity entity = response.getEntity();

		ContentType contentType = ContentType.getOrDefault(entity);
		Charset charset = contentType.getCharset();
		if (charset == null) {
			charset = Charset.defaultCharset();
		}

		return charset;
	}
}