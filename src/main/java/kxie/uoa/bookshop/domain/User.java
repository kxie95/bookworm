package kxie.uoa.bookshop.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long _id;
	
	@Column(unique=true, nullable=false)
	private String _username;
	
	@Column
	private String _lastname;
	
	@Column
	private String _firstname;
	
	private Address _address;
	
	private ShoppingCart _shoppingCart;
	
	private List<Order> _orderHistory;
	
	private List<Review> _reviews;
	
	public User(String username, String lastname, String firstname, Address address) {
		_username = username;
		_lastname = lastname;
		_firstname = firstname;
		_address = address;
	}
	
	public User(String username) {
		this(username, null, null, null);
	}
	
	protected User() {}
	
	public Long getId() {
		return _id;
	}
	
	public String getUsername() {
		return _username;
	}
	
	public String getLastname() {
		return _lastname;
	}
	
	public String getFirstname() {
		return _firstname;
	}

	public Address getAddress() {
		return _address;
	}

	public void setAddress(Address address) {
		_address = address;
	}

	public ShoppingCart getShoppingCart() {
		return _shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		_shoppingCart = shoppingCart;
	}

	public List<Order> getOrderHistory() {
		return _orderHistory;
	}

	public void setOrderHistory(List<Order> orderHistory) {
		_orderHistory = orderHistory;
	}

	public List<Review> getReviews() {
		return _reviews;
	}

	public void setReviews(List<Review> reviews) {
		_reviews = reviews;
	}
}
