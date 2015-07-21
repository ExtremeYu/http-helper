package com.robert.httphelper;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class Sample {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		String result = Request.Get("http://www.baidu.com").execute()
				.handleResponse(Helper.json2ObjectConverter(String.class));
		
		System.out.println(result);
	}
}
