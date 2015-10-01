package kxie.uoa.bookshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A class to represent a user account.
 * 
 * Relationships:
 * OneToMany with Reviews
 * OneToMany with Orders
 * 
 * @author Karen Xie kxie094
 *
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique=true, nullable=false)
	private String username;

	@Column
	private String password;

	@Column
	private String lastname;

	@Column
	private String firstname;

	protected User() {
	}

	/**
	 * Constructs a User instance. Id is set by database.
	 */
	public User(String username, String password, String lastname, String firstname) {
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
	}
	
	// Getters and Setters
	public long getId() {return id;}

	public void setId(long id) {this.id = id;}

	public String getUsername() {return username;}

	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	public String getLastname() {return lastname;}

	public void setLastname(String lastname) {this.lastname = lastname;}

	public String getFirstname() {return firstname;}

	public void setFirstname(String firstname) {this.firstname = firstname;}
}
