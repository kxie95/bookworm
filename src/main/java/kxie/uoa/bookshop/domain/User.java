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
	
	@Column
	private String _password;
	
	private ShoppingCart _shoppingCart;
	
	private List<Order> _orderHistory;
	
	private List<Review> _reviews;
	
	public User(String username, String password, String lastname, String firstname) {
		_username = username;
		_password = password;
		_lastname = lastname;
		_firstname = firstname;
	}
	
	public User(long id, String username, String password, String lastname, String firstname) {
		_id = id;
		_username = username;
		_password = password;
		_lastname = lastname;
		_firstname = firstname;
	}
	
	public User(String username) {
		this(username, null, null, null);
	}
	
	protected User() {}
	
	public Long getId() {
		return _id;
	}
	
	public void setId(long id) {
		_id = id;	
	}
	
	public String getUsername() {
		return _username;
	}
	
	public String getPassword() {
		return _password;
	}
	
	public void setPassword(String password) {
		_password = password;
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

	public void addOrderToHistory(Order order) {
		_orderHistory.add(order);
	}

}
