package model;

public abstract class Thing {
	protected String serialNumber;
	protected String name;

	public Thing() {

	}

	public Thing(String serialNumber, String name) {
		this.serialNumber = serialNumber;
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	abstract String getDescription();
}
