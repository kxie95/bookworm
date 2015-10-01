package kxie.uoa.bookshop.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDto {

	@XmlAttribute(name = "id")
	private long id;

	@XmlElement(name = "username")
	private String username;

	@XmlElement(name = "password")
	private String password;

	@XmlElement(name = "last-name")
	private String lastname;

	@XmlElement(name = "first-name")
	private String firstname;

	protected UserDto() {

	}

	/**
	 * Constructs a DTO User instance. This method is intended to be called by
	 * Web service clients when creating new Users.
	 */
	public UserDto(String username, String password, String lastname, String firstname) throws IllegalArgumentException {
		this(0, username, password, lastname, firstname);
	}

	/**
	 * Constructs a DTO User instance. It is intended to be used by the Web
	 * Service implementation when creating a DTO User from a domain-model User
	 * object.
	 */
	public UserDto(long id, String username, String password, String lastname, String firstname) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
	}
	
	// Getters and Setters

	public long getId() {return id;}

	public String getLastname() {return lastname;}

	public void setLastname(String lastname) {this.lastname = lastname;}

	public String getFirstname() {return firstname;}

	public void setFirstname(String firstname) {this.firstname = firstname;}

	public String getUsername() {return username;}

	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof UserDto))
			return false;
		if (obj == this)
			return true;

		UserDto rhs = (UserDto) obj;
		return new EqualsBuilder().append(id, rhs.id).append(username, rhs.id).append(password, rhs.password)
				.append(lastname, rhs.lastname).append(firstname, rhs.firstname).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(id).toHashCode();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("User: { [");
		buffer.append(id);
		buffer.append("]; ");

		if (username != null) {
			buffer.append(username);
		}

		buffer.append("\n  ");
		if (password != null) {
			buffer.append(password);
		}

		if (lastname != null) {
			buffer.append(lastname);
			buffer.append(", ");
		}

		if (firstname != null) {
			buffer.append(firstname);
		}

		buffer.append("; ");

		buffer.append(" }");

		return buffer.toString();
	}

}
