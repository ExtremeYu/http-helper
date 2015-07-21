package com.robert.httphelper;

public abstract class Helper {

	public static <T> Json2BeanConverter<T> json2BeanConverter(Class<T> clazz) {
		return new Json2BeanConverter<T>(clazz);
	}

	public static <T> Json2BeansConverter<T> json2BeansConverter(Class<T> clazz) {
		return new Json2BeansConverter<T>(clazz);
	}

	public static Json2ObjectConverter json2ObjectConverter() {
		return new Json2ObjectConverter();
	}

	public static Xml2DocumentConverter xml2DocumentConverter() {
		return new Xml2DocumentConverter();
	}

	public static IntConverter intConverter() {
		return new IntConverter();
	}

	public static LongConverter longConverter() {
		return new LongConverter();
	}

	public static FloatConverter floatConverter() {
		return new FloatConverter();
	}

	public static DoubleConverter doubleConverter() {
		return new DoubleConverter();
	}

	public static BigDecimalConverter bitDecimalConverter() {
		return new BigDecimalConverter();
	}

	public static BooleanConverter booleanConverter() {
		return new BooleanConverter();
	}

}
