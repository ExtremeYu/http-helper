package com.robert.httphelper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

public abstract class AbstractConverter {

	protected String resp2String(HttpResponse response)
			throws HttpResponseException, ClientProtocolException, IOException {
		StatusLine statusLine = response.getStatusLine();
		HttpEntity entity = response.getEntity();

		if (statusLine.getStatusCode() >= 300) {
			throw new HttpResponseException(statusLine.getStatusCode(),
					statusLine.getReasonPhrase());
		}
		if (entity == null) {
			throw new ClientProtocolException("Response contains no content");
		}

		Charset charset = getCharset(response);

		String str = new String(EntityUtils.toByteArray(entity), charset);
		return str;
	}

	protected InputStream resp2InputStream(HttpResponse response)
			throws UnsupportedOperationException, IOException {
		StatusLine statusLine = response.getStatusLine();
		HttpEntity entity = response.getEntity();

		if (statusLine.getStatusCode() >= 300) {
			throw new HttpResponseException(statusLine.getStatusCode(),
					statusLine.getReasonPhrase());
		}
		if (entity == null) {
			throw new ClientProtocolException("Response contains no content");
		}

		InputStream is = entity.getContent();
		return is;
	}

	protected Charset getCharset(HttpResponse response)
			throws ClientProtocolException {
		HttpEntity entity = response.getEntity();
		ContentType contentType = ContentType.getOrDefault(entity);
		if (!contentType.equals(ContentType.APPLICATION_XML)) {
			throw new ClientProtocolException("Unexpected content type:"
					+ contentType);
		}

		Charset charset = contentType.getCharset();
		if (charset == null) {
			charset = Charset.defaultCharset();
		}
		return charset;
	}
}