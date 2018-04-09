package com.tdd.barcode.bacodetransfer;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class BarCodeTransfer {

	static List<Integer> legalLen = new ArrayList<Integer>();
	static Map<String, String> postCodeMap = new HashMap<String, String>();
	static Map<String, String> barCodeMap = new HashMap<String, String>();

	static {
		legalLen.add(5);
		legalLen.add(9);
		legalLen.add(10);
		postCodeMap.put("1", ":::||");
		postCodeMap.put("2", "::|:|");
		postCodeMap.put("3", "::||:");
		postCodeMap.put("4", ":|::|");
		postCodeMap.put("5", ":|:|:");
		postCodeMap.put("6", ":||::");
		postCodeMap.put("7", "|:::|");
		postCodeMap.put("8", "|::|:");
		postCodeMap.put("9", "|:|::");
		postCodeMap.put("0", "||:::");
		barCodeMap.put(":::||", "1");
		barCodeMap.put("::|:|", "2");
		barCodeMap.put("::||:", "3");
		barCodeMap.put(":|::|", "4");
		barCodeMap.put(":|:|:", "5");
		barCodeMap.put(":||::", "6");
		barCodeMap.put("|:::|", "7");
		barCodeMap.put("|::|:", "8");
		barCodeMap.put("|:|::", "9");
		barCodeMap.put("||:::", "0");
	}

	public static boolean validPostCode(String postCode) {
		if (postCode == null) {
			return false;
		}
		for (int i = postCode.length(); --i >= 0;) {
			if (!Character.isDigit(postCode.charAt(i))) {
				return false;
			}
		}
		if (!legalLen.contains(postCode.length())) {
			return false;
		}
		return true;
	}

	public static boolean validBarCode(String barCode) {
		barCode.startsWith("|");
		return false;
	}

	public static String transferPostCard2BarCode(String postCode) {
		String result = "|";
		int sum = 0;
		for (int i = postCode.length(); --i >= 0;) {
			sum = sum + (postCode.charAt(i) - '0');
			if (postCodeMap.get(String.valueOf(postCode.charAt(i))) != null) {
				result = result
						+ postCodeMap.get(String.valueOf(postCode.charAt(i)));
			}
		}
		int validCode = sum % 10;
		return result + postCodeMap.get(String.valueOf(validCode)) + "|";
	}

	public static String transferBarCard2PostCode(String barCode) {
		String result = "";
		barCode = barCode.substring(1, barCode.length() - 1);
		for (int i = barCode.length(); --i >= 0;) {
			if (barCodeMap.get(barCode.substring(i*5, i*5 + 5)) != null) {
				result = result + barCodeMap.get(barCode.substring(i, i + 5));
			}
		}
		return result.substring(0,result.length()-1);
	}

	public static void printCode(String code) {
		System.out.println(code);
	}
}
