package com.robert.httphelper.converter.abs;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.ContentType;

public abstract class AbstractJsonConverter<T> extends AbstractStrConverter<T> {

	protected void checkFormat(HttpResponse response)
			throws ClientProtocolException {
		HttpEntity entity = response.getEntity();
		ContentType contentType = ContentType.getOrDefault(entity);
		if (!contentType.equals(ContentType.APPLICATION_JSON)) {
			throw new ClientProtocolException("Unexpected content type:"
					+ contentType);
		}
	}

}