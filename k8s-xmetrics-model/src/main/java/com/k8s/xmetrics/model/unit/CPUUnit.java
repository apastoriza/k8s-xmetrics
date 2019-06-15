package com.k8s.xmetrics.model.unit;

/**
 * @author apastoriza
 */
public enum CPUUnit {
	NANOCORE("n"),
	MILLICORE("m");

	private final String symbol;

	CPUUnit(final String symbol){
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}
}
