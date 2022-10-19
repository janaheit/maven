package be.abis.mavenexercise.model;

public class Company {
	
	private String name;
	private Address address;
	
	public Company(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	// business methods

	public double calculateTaxToPay(){
		switch (address.getCountryCode()){
			case "BE":
				return 51.0;
			case "NL":
				return 47.0;
			default:
				return 35.0;
		}
	}

	// getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	

}
