package com.robert.httphelper.converter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Xml2DocumentConverter extends AbstractConverter implements
		ResponseHandler<Document> {

	public Document handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {

		HttpEntity entity = response.getEntity();
		ContentType contentType = ContentType.getOrDefault(entity);
		if (!contentType.equals(ContentType.APPLICATION_XML)) {
			throw new ClientProtocolException("Unexpected content type:"
					+ contentType);
		}

		Charset charset = getCharset(response);

		InputStream is = resp2InputStream(response);

		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			return docBuilder.parse(is, charset.toString());
		} catch (ParserConfigurationException ex) {
			throw new IllegalStateException(ex);
		} catch (SAXException ex) {
			throw new ClientProtocolException("Malformed XML document", ex);
		}
	}
	
}
