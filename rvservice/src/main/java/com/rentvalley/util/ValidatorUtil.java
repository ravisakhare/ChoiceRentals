package com.rentvalley.util;

public class ValidatorUtil {
	
	public boolean isEmpty(String s) {
		if (s == null || s.trim().length() == 0) {
			return true;
		}
		return false;
	}
}
