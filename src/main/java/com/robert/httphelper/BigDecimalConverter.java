package com.robert.httphelper;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

public class BigDecimalConverter extends AbstractConverter implements
		ResponseHandler<BigDecimal> {

	public BigDecimal handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		String str = resp2String(response);
		return new BigDecimal(str);
	}

}
