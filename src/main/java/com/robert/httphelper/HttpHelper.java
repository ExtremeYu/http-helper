package com.robert.httphelper;

import com.robert.httphelper.converter.BigDecimalConverter;
import com.robert.httphelper.converter.BooleanConverter;
import com.robert.httphelper.converter.DoubleConverter;
import com.robert.httphelper.converter.FloatConverter;
import com.robert.httphelper.converter.IntConverter;
import com.robert.httphelper.converter.Json2BeanConverter;
import com.robert.httphelper.converter.Json2BeansConverter;
import com.robert.httphelper.converter.Json2ObjectConverter;
import com.robert.httphelper.converter.LongConverter;
import com.robert.httphelper.converter.Xml2DocumentConverter;

public abstract class HttpHelper {

	public static <T> Json2BeanConverter<T> Json2BeanConverter(Class<T> clazz) {
		return new Json2BeanConverter<T>(clazz);
	}

	public static <T> Json2BeansConverter<T> Json2BeansConverter(Class<T> clazz) {
		return new Json2BeansConverter<T>(clazz);
	}

	public static Json2ObjectConverter Json2ObjectConverter() {
		return new Json2ObjectConverter();
	}

	public static Xml2DocumentConverter Xml2DocumentConverter() {
		return new Xml2DocumentConverter();
	}

	public static IntConverter IntConverter() {
		return new IntConverter();
	}

	public static LongConverter LongConverter() {
		return new LongConverter();
	}

	public static FloatConverter FloatConverter() {
		return new FloatConverter();
	}

	public static DoubleConverter DoubleConverter() {
		return new DoubleConverter();
	}

	public static BigDecimalConverter BitDecimalConverter() {
		return new BigDecimalConverter();
	}

	public static BooleanConverter BooleanConverter() {
		return new BooleanConverter();
	}

}
