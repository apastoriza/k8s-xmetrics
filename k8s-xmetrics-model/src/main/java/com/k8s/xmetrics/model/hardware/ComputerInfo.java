package com.k8s.xmetrics.model.hardware;

/**
 * @author apastoriza
 */
public class ComputerInfo {
	private String manufacturer;
	private String model;
	private String serialNumber;

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(final String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(final String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(final String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		final ComputerInfo that = (ComputerInfo) o;

		return this.serialNumber != null ? this.serialNumber.equals(that.serialNumber) : that.serialNumber == null;
	}

	@Override
	public int hashCode() {
		return this.serialNumber != null ? this.serialNumber.hashCode() : 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ComputerInfo{");
		sb.append("manufacturer='").append(this.manufacturer).append('\'');
		sb.append(", model='").append(this.model).append('\'');
		sb.append(", serialNumber='").append(this.serialNumber).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
