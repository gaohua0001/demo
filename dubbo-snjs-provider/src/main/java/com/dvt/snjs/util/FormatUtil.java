package com.dvt.snjs.util;

public class FormatUtil {

	public static String format(String value, String defaultvalue) {
		if(value == null) {
			return defaultvalue;
		} else {
			return value.trim();
		}
	}
}
