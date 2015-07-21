package com.robert.httphelper;

public abstract class Helper {
	public static <T> Json2ObjectConverter<T> json2ObjectConverter(
			Class<T> clazz) {
		return new Json2ObjectConverter<T>(clazz);
	}

	public static <T> Json2ObjectConverter<T> json2JsonObjectConverter(
			Class<T> clazz) {
		return new Json2ObjectConverter<T>(clazz);
	}

	public static <T> Json2ObjectConverter<T> json2DocumentConverter(
			Class<T> clazz) {
		return new Json2ObjectConverter<T>(clazz);
	}
}
