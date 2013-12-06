package se.kehe.pojo;

public class Customer {
	
	private String name;
	private String address;
	private String zip;
	private String municipality;
	private String phone;
	
	public Customer(String name, String address, String zip, String municipality, String phone) {
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.municipality = municipality;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
