package kxie.uoa.bookshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	@Id
	@Column(name="ADDR_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long _id;
	
	@Column(name="STREET_NO")
	private int _streetNumber;
	
	@Column(name="STREET_NAME")
	private String _streetName;
	
	@Column(name="SUBURB")
	private String _suburb;
	
	@Column(name="CITY")
	private String _city;
	
	public Long getId() {
		return _id;
	}
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
	
	public void setSuburb(String suburb) {
		_suburb = suburb;
	}
	
	public String getCity() {
		return _city;
	}
	
	public void setCity(String city) {
		_city = city;
	}
}
