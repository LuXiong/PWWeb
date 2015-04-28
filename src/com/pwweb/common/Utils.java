package com.pwweb.common;

import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class Utils {
//	public static String generateUUid(String s) {
//		return generateUUidInString(UUID.fromString(s));
//	}

	public static String generateUUid() {
		return generateUUidInString(UUID.randomUUID());
	}

	private static String generateUUidInString(UUID uuid) {
		String s = uuid.toString();
		String[] temp = s.split("-");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < temp.length; i++) {
			builder.append(temp[i]);
		}
		return builder.toString();
	}
}
