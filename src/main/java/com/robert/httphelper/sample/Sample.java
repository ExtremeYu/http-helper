package com.robert.httphelper.sample;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.robert.httphelper.HttpHelper;

public class Sample {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		List<String> result = Request.Get("http://www.baidu.com").execute()
				.handleResponse(HttpHelper.Json2BeansConverter(String.class));

		System.out.println(result);
	}
}
