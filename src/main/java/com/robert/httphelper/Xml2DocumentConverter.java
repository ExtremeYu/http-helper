package com.robert.httphelper;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Xml2DocumentConverter implements ResponseHandler<Document> {

	public Document handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		StatusLine statusLine = response.getStatusLine();
		HttpEntity entity = response.getEntity();
		if (statusLine.getStatusCode() >= 300) {
			throw new HttpResponseException(statusLine.getStatusCode(),
					statusLine.getReasonPhrase());
		}
		if (entity == null) {
			throw new ClientProtocolException("Response contains no content");
		}
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			ContentType contentType = ContentType.getOrDefault(entity);
			if (!contentType.equals(ContentType.APPLICATION_XML)) {
				throw new ClientProtocolException("Unexpected content type:"
						+ contentType);
			}
			Charset charset = contentType.getCharset();
			if (charset == null) {
				charset = Charset.defaultCharset();
			}
			return docBuilder.parse(entity.getContent(), charset.toString());
		} catch (ParserConfigurationException ex) {
			throw new IllegalStateException(ex);
		} catch (SAXException ex) {
			throw new ClientProtocolException("Malformed XML document", ex);
		}
	}

}
