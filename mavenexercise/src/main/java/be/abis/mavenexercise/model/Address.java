package be.abis.mavenexercise.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Address {
	
	private String street;
	private String nr;
	private String zipCode;
	private String town;
	private String country;
	private String countryCode;
	
	public Address(String street, String nr, String zipCode, String town, String country, String countryCode) {
		this.street = street;
		this.nr = nr;
		this.zipCode = zipCode;
		this.town = town;
		this.country = country;
		this.countryCode = countryCode;
	}

	// business methods
	public Boolean isBelgianZipCodeNumeric(){
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

		if (zipCode == null) return false;

		return pattern.matcher(zipCode).matches();
	}

	// getters and setters

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void writeToFile() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("/temp/javacourses/address.txt", true));

		StringBuilder addressString = buildAddressString();

		pw.println(addressString);
		pw.close();
	}

	public void writeToFile(Path pathToFile) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(pathToFile.toString(), true));

		StringBuilder addressString = buildAddressString();

		pw.println(addressString);
		pw.close();
	}

	private StringBuilder buildAddressString(){
		StringBuilder addressString = new StringBuilder();

		addressString.append(street);
		addressString.append(" ");
		addressString.append(nr);
		addressString.append(", ");
		addressString.append(zipCode);
		addressString.append(" ");
		addressString.append(town);
		addressString.append(", ");
		addressString.append(country);

		return addressString;
	}
}
