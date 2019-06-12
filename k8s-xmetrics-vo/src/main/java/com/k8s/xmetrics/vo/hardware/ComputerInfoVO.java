package com.k8s.xmetrics.vo.hardware;

import com.k8s.xmetrics.vo.AbstractAgentVO;

/**
 * @author apastoriza
 */
public class ComputerInfoVO extends AbstractAgentVO {
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
	public String toString() {
		final StringBuilder sb = new StringBuilder("ComputerInfoVO{");
		sb.append("manufacturer='").append(this.manufacturer).append('\'');
		sb.append(", model='").append(this.model).append('\'');
		sb.append(", serialNumber='").append(this.serialNumber).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
