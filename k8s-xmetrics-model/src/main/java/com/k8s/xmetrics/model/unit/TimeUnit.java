package com.k8s.xmetrics.model.unit;

/**
 * @author apastoriza
 */
public enum TimeUnit {
	SECOND("s"), MINUTE("m");

	private final String symbol;

	TimeUnit(final String symbol){
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}
}
