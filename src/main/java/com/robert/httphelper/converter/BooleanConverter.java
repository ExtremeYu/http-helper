package com.robert.httphelper.converter;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

public class BooleanConverter extends AbstractConverter implements
		ResponseHandler<Boolean> {

	public Boolean handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		String str = resp2String(response);
		return new Boolean(str);
	}

}
