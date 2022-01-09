package com.telia.uniservice.constants;

public class RegEx {

	public static final String SwedenNationalIDRegEx = "\\b(((20)((0[0-9])|(1[0-1])))|(([1][^0-8])?\\d{2}))((0[1-9])|1[0-2])((0[1-9])|(2[0-9])|(3[01]))[-+]?\\d{4}[,.]?\\b";
	public static final String FinlandNationalIDRegEx = "^(0[1-9]|[12]\\d|3[01])(0[1-9]|1[0-2])([5-9]\\d\\+|\\d\\d-|[01]\\dA)\\d{3}[\\dABCDEFHJKLMNPRSTUVWXY]$";
	
	private final String name;
	private RegEx(String name) {
		this.name = name;
	}
}
