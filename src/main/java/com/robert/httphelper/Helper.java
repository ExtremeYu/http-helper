package com.robert.httphelper;

public abstract class Helper {
	public static <T> Json2BeanConverter<T> json2BeanConverter(Class<T> clazz) {
		return new Json2BeanConverter<T>(clazz);
	}

	public static <T> Json2BeanConverter<T> json2ObjectConverter(Class<T> clazz) {
		return new Json2BeanConverter<T>(clazz);
	}

	public static <T> Json2BeanConverter<T> json2DocumentConverter(
			Class<T> clazz) {
		return new Json2BeanConverter<T>(clazz);
	}
}
