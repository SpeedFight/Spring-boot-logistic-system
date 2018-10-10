package com.bootLogisticSystem.model;

public enum RaportType {
	A("a","Ilość zamówień łącznie"),
	B("b","Ilość zamówień do klienta o wskazanym identyfikatorze"),
	C("c","Łączna kwota zamówień"),
	D("d","Łączna kwota zamówień do klienta o wskazanym identyfikatorze"),
	E("e","Lista wszystkich zamówień"),
	F("f","Lista zamówień do klienta o wskazanym identyfikatorze"),
	G("g","Średnia wartość zamówienia"),
	H("h","Średnia wartość zamówienia do klienta o wskazanym identyfikatorze");
	
	private final String code;
	private final String description;
	
	private RaportType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
