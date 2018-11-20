package com.tecsup.gestion.model;

public class Deparment {
	int deparmentId;
	String name;
	String description;
	String city;
	
	/**
	 * 
	 * @param deparmentId
	 * @param name
	 * @param description
	 * @param city
	 */
	
	public Deparment(int deparmentId, String name, String description, String city) {
		super();
		this.deparmentId = deparmentId;
		this.name = name;
		this.description = description;
		this.city = city;
	}

	public Deparment() {
		super();
	}

	public int getDeparmentId() {
		return deparmentId;
	}

	public void setDeparmentId(int deparmentId) {
		this.deparmentId = deparmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Deparment [deparmentId=" + deparmentId + ", name=" + name + ", description=" + description
				+ ", city=" + city + "]";
	}
}
