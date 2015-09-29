package kxie.uoa.bookshop.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import kxie.uoa.bookshop.domain.Order;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/* Class to represent a User. 
 *  
 * A DTO User is described by:
 * - username, password, lastname, firstname
 * 
 * A User is uniquely identified by an id value of type long.
 * 
 */

@XmlRootElement(name = "user")
public class UserDto {

	@XmlAttribute(name = "id")
	private long _id;

	@XmlElement(name = "username")
	private String _username;

	@XmlElement(name = "password")
	private String _password;

	@XmlElement(name = "last-name")
	private String _lastname;

	@XmlElement(name = "first-name")
	private String _firstname;

	@XmlElement(name = "most-recent-order")
	private Order _mostRecentOrder;

	protected UserDto() {

	}

	/**
	 * Constructs a DTO User instance. This method is intended to be called by
	 * Web service clients when creating new Users.
	 */
	public UserDto(String username, String password, String lastname, String firstname)
			throws IllegalArgumentException {
		this(0, username, password, lastname, firstname, null);
	}

	/**
	 * Constructs a DTO User instance. It is intended to be used by the Web
	 * Service implementation when creating a DTO User from a domain-model
	 * Parolee object.
	 */
	public UserDto(long id, String username, String password, String lastname, String firstname, Order mostRecent) {
		_id = id;
		_username = username;
		_password = password;
		_lastname = lastname;
		_firstname = firstname;
		_mostRecentOrder = mostRecent;
	}

	public long getId() {
		return _id;
	}

	public String getLastname() {
		return _lastname;
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public String getFirstname() {
		return _firstname;
	}

	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public Order getMostRecentOrder() {
		return _mostRecentOrder;
	}

	public void setMostRecentOrder(Order mostRecentOrder) {
		_mostRecentOrder = mostRecentOrder;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof UserDto))
			return false;
		if (obj == this)
			return true;

		UserDto rhs = (UserDto) obj;
		return new EqualsBuilder().
				append(_id, rhs._id).
				append(_username, rhs._id).
				append(_password, rhs._password).
				append(_lastname, rhs._lastname).
				append(_firstname, rhs._firstname).
				isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).
				append(_id).
				append(_username).
				append(_password).
				append(_lastname).
				append(_firstname).
				toHashCode();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("User: { [");
		buffer.append(_id);
		buffer.append("]; ");

		if (_username != null) {
			buffer.append(_username);
		}

		buffer.append("\n  ");
		if (_password != null) {
			buffer.append(_password);
		}

		if (_lastname != null) {
			buffer.append(_lastname);
			buffer.append(", ");
		}

		if (_firstname != null) {
			buffer.append(_firstname);
		}

		buffer.append("; ");

		buffer.append(" }");

		return buffer.toString();
	}

}
