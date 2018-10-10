package com.bootLogisticSystem.model;

public enum RaportType {
	A("a", "Ilość zamówień łącznie", false),
	B("b", "Ilość zamówień do klienta o wskazanym identyfikatorze", true),
	C("c", "Łączna kwota zamówień", false),
	D("d", "Łączna kwota zamówień do klienta o wskazanym identyfikatorze", true),
	E("e", "Lista wszystkich zamówień", false),
	F("f", "Lista zamówień do klienta o wskazanym identyfikatorze", true),
	G("g", "Średnia wartość zamówienia", false),
	H("h", "Średnia wartość zamówienia do klienta o wskazanym identyfikatorze", true);
	
	private final String code;
	private final String description;
	private final boolean requireClientId;
	
	private RaportType(String code, String description, boolean requireClientId) {
		this.code = code;
		this.description = description;
		this.requireClientId = requireClientId;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public boolean isRequireClientId() {
		return requireClientId;
	}
}
