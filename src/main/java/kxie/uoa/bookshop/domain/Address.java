package kxie.uoa.bookshop.domain;

public class Address {
	private int _streetNumber;
	private String _streetName;
	private String _suburb;
	private String _city;
	
	public int getStreetNumber() {
		return _streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		_streetNumber = streetNumber;
	}
	public String getStreetName() {
		return _streetName;
	}
	public void setStreetName(String streetName) {
		_streetName = streetName;
	}
	public String getSuburb() {
		return _suburb;
	}
	public void set_suburb(String suburb) {
		_suburb = suburb;
	}
	public String get_city() {
		return _city;
	}
	public void set_city(String city) {
		_city = city;
	}
}
