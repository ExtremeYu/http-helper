package com.robert.httphelper.converter;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

public class IntConverter extends AbstractConverter implements
		ResponseHandler<Integer> {

	public Integer handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		String str = resp2String(response);
		return new Integer(str);
	}

}
