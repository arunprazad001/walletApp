package com.example.demo.model;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {
   
	
	public static String StringGenerator() {
		int stringLength = 10;
        String randomString = RandomStringUtils.randomAlphanumeric(stringLength);
        return randomString;
	}
}
