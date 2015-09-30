package kxie.uoa.bookshop.domain;

import java.util.HashMap;

public class ShoppingCart {

	private HashMap<Book, Integer> _booksInCart;
	private User _user;

	public HashMap<Book, Integer> getBooksInCart() {
		return _booksInCart;
	}

	public void setBooksInCart(HashMap<Book, Integer> booksInCart) {
		_booksInCart = booksInCart;
	}

	public User getUser() {
		return _user;
	}

	public void setUser(User user) {
		_user = user;
	}

	public void addToCart(Book book, int quantity) {
		_booksInCart.put(book, quantity);
	}

	public void removeFromCart(Book book) {
		_booksInCart.remove(book);
	}

	public double getTotal() {
		double total = 0.0;
		for (Book book : _booksInCart.keySet()) {
			total += book.getPrice();
		}
		return total;
	}

	/**
	 * Makes a new order from the cart items.
	 */
	public Order checkoutCart() {
		Order order = new Order();
		order.setTotalCost(getTotal());
		order.setBooksOrdered(_booksInCart);
		order.setCustomerName(_user.getFirstname() + " " + _user.getLastname());
		order.setOrderStatus("Processing");
		return order;
	}
}
