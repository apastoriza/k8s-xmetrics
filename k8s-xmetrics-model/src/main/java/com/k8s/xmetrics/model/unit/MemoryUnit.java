package com.k8s.xmetrics.model.unit;

/**
 * @author apastoriza
 */
public enum MemoryUnit {
	//Decimal Units
	KILOBYTES("K"),
	MEGABYTES("M"),
	GIGABYTES("G"),
	TERABYTES("T"),
	PETABYTES("P"),
	EXABYTES("E"),
	ZETTABYTES("Z"),
	YOTTABYTES("Y"),
	//Binary Units
	KIBIBYTES("Ki"),
	MEBIBYTES("Mi"),
	GIBIBYTES("Gi"),
	TEBIBYTES("Ti"),
	PEBIBYTES("Pi"),
	EXBIBYTES("Ei"),
	ZEBIBYTES("Zi"),
	YOBIBYTES("Yi");

	private final String symbol;

	MemoryUnit(final String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}
}
