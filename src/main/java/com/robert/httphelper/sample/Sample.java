package com.robert.httphelper.sample;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.w3c.dom.Document;

import com.alibaba.fastjson.JSONObject;
import com.robert.httphelper.HttpHelper;

/**
 * <p>
 * Samples used to show how to use the APIs.
 * </p>
 *
 * @author Robert Lee
 * @version 1.0
 * @since Jul 15, 2015
 */

public class Sample {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		// Read String object
		String stringResult = Request.Get("http://ip:port").execute()
				.returnContent().asString();
		System.out.println(stringResult);

		// Read String object with Charset
		String stringResultWithCharset = Request.Get("http://ip:port")
				.execute().returnContent().asString(Charset.defaultCharset());
		System.out.println(stringResultWithCharset);

		// Read Stream Object
		InputStream is = Request.Get("http://ip:port").execute()
				.returnContent().asStream();
		// Handle the input stream
		is.close();

		// Read raw bytes
		byte[] bytes = Request.Get("http://ip:port").execute().returnContent()
				.asBytes();
		System.out.println(bytes.length);

		// Read int variable
		int intResult = Request.Get("http://ip:port").execute()
				.handleResponse(HttpHelper.IntConverter());
		System.out.println(intResult);

		// Read long variable
		long longResult = Request.Get("http://ip:port").execute()
				.handleResponse(HttpHelper.LongConverter());
		System.out.println(longResult);

		// Read float variable
		float floatResult = Request.Get("http://ip:port").execute()
				.handleResponse(HttpHelper.FloatConverter());
		System.out.println(floatResult);

		// Read double variable
		double doulbeResult = Request.Get("http://ip:port").execute()
				.handleResponse(HttpHelper.DoubleConverter());
		System.out.println(doulbeResult);

		// Read BigDecimal object
		BigDecimal bitDecimalResult = Request.Get("http://ip:port").execute()
				.handleResponse(HttpHelper.BitDecimalConverter());
		System.out.println(bitDecimalResult);

		// Read Bean
		Student beanResult = Request.Get("http://ip:port").execute()
				.handleResponse(HttpHelper.Json2BeanConverter(Student.class));
		System.out.println(beanResult);

		// Read Bean List
		List<Student> beanListResult = Request.Get("http://ip:port").execute()
				.handleResponse(HttpHelper.Json2BeansConverter(Student.class));
		System.out.println(beanListResult);

		// Read XML Document object
		Document documentResult = Request.Get("http://ip:port").execute()
				.handleResponse(HttpHelper.Xml2DocumentConverter());
		System.out.println(documentResult.toString());

		// Read JSONObject object
		JSONObject jsonObjectResult = Request.Get("http://ip:port").execute()
				.handleResponse(HttpHelper.Json2ObjectConverter());
		System.out.println(jsonObjectResult.toJSONString());
	}
}
