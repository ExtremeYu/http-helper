package com.robert.httphelper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.robert.httphelper.sample.Student;

/**
 * <p>
 * Unit test with testng and mockito.
 * </p>
 *
 * @author Robert Lee
 * @version 1.0
 * @since Jul 15, 2015
 */

public class HttpHelperTest {

	@BeforeClass
	public void setUp() {
		// code that will be invoked when this test is instantiated
	}

	@Test(groups = { "primaryDataType" })
	public void intConverterTest() throws ClientProtocolException, IOException {

		HttpResponse httpResponse = mockResponse("1");

		int result = HttpHelper.IntConverter().handleResponse(httpResponse);

		Assert.assertEquals(result, 1);
	}

	@Test(groups = { "primaryDataType" })
	public void longConverterTest() throws ClientProtocolException, IOException {

		HttpResponse httpResponse = mockResponse("1");

		long result = HttpHelper.LongConverter().handleResponse(httpResponse);

		Assert.assertEquals(result, 1);
	}

	@Test(groups = { "primaryDataType" })
	public void floatConverterTest() throws ClientProtocolException,
			IOException {

		HttpResponse httpResponse = mockResponse("1.1");

		float result = HttpHelper.FloatConverter().handleResponse(httpResponse);

		Assert.assertEquals(result, 1.1f);
	}

	@Test(groups = { "primaryDataType" })
	public void doubleConverterTest() throws ClientProtocolException,
			IOException {

		HttpResponse httpResponse = mockResponse("1.11111");

		double result = HttpHelper.DoubleConverter().handleResponse(
				httpResponse);

		Assert.assertEquals(result, 1.11111d);
	}

	@Test(groups = { "primaryDataType" })
	public void bigDecimalConverterTest() throws ClientProtocolException,
			IOException {

		HttpResponse httpResponse = mockResponse("1.1111111111");

		BigDecimal result = HttpHelper.BitDecimalConverter().handleResponse(
				httpResponse);

		Assert.assertEquals(result, new BigDecimal("1.1111111111"));
	}

	@Test(groups = { "xml" })
	public void xml2DocumentConverterTest() throws ClientProtocolException,
			IOException {

		HttpResponse httpResponse = mockResponse("<test>test</test>");

		Document result = HttpHelper.Xml2DocumentConverter().handleResponse(
				httpResponse);

		Assert.assertEquals(result.getDocumentElement().getTextContent(),
				"test");
	}

	@Test(groups = { "json" })
	public void json2ObjectConverterTest() throws ClientProtocolException,
			IOException {

		HttpResponse httpResponse = mockResponse("{\"name\":\"robert\", \"years\":8}");

		JSONObject result = HttpHelper.Json2ObjectConverter().handleResponse(
				httpResponse);

		Assert.assertEquals(result.getString("name"), "robert");
		Assert.assertEquals(result.getIntValue("years"), 8);
	}

	@Test(groups = { "json" })
	public void json2BeanConverterTest() throws ClientProtocolException,
			IOException {
		Student student = new Student("robert", 8);
		HttpResponse httpResponse = mockResponse(JSON.toJSONString(student));

		Student result = HttpHelper.Json2BeanConverter(Student.class)
				.handleResponse(httpResponse);

		Assert.assertEquals(result, student);
	}

	@Test(groups = { "json" })
	public void json2BeansConverterTest() throws ClientProtocolException,
			IOException {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("robert", 8));
		students.add(new Student("robert", 8));
		HttpResponse httpResponse = mockResponse(JSON.toJSONString(students));

		List<Student> result = HttpHelper.Json2BeansConverter(Student.class)
				.handleResponse(httpResponse);

		Assert.assertEquals(result.size(), 2);
		Assert.assertEquals(result, students);
	}

	private HttpResponse mockResponse(String content) throws IOException {
		HttpResponse httpResponse = mock(HttpResponse.class);
		StatusLine statusLine = mock(StatusLine.class);
		HttpEntity httpEntity = mock(HttpEntity.class);

		when(httpResponse.getStatusLine()).thenReturn(statusLine);
		when(statusLine.getStatusCode()).thenReturn(200);

		when(httpResponse.getEntity()).thenReturn(httpEntity);
		when(httpEntity.getContent()).thenReturn(
				new ByteArrayInputStream(content.getBytes()));
		return httpResponse;
	}

}
