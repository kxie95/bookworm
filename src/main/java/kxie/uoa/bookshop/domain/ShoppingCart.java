package kxie.uoa.bookshop.domain;

import java.util.HashSet;

import kxie.uoa.bookshop.domain.Order.OrderStatus;

public class ShoppingCart {
	private HashSet<BookOrder> _booksInCart;
	private User _user;

	public HashSet<BookOrder> getBooksInCart() {
		return _booksInCart;
	}

	public void set_booksInCart(HashSet<BookOrder> booksInCart) {
		_booksInCart = booksInCart;
	}

	public User getUser() {
		return _user;
	}

	public void setUser(User user) {
		_user = user;
	}

	public void addToCart(Book book, int quantity) {
		_booksInCart.add(new BookOrder(book.getIsbn(), quantity));
	}

	public void removeFromCart(Book book) {
		_booksInCart.remove(book);
	}

	// public double getTotal() {
	// double total = 0.0;
	// for (BookOrder book : _booksInCart) {
	// total += book.getPrice();
	// }
	// return total;
	// }

	/**
	 * Makes a new order from the cart items.
	 */
	public Order checkoutCart() {
		Order order = new Order();
		// order.setTotalCost(getTotal());
		order.setBooksOrdered(_booksInCart);
		order.setCustomerName(_user.getFirstname() + " " + _user.getLastname());
		order.setOrderStatus(OrderStatus.PROCESSING);
		return order;
	}
}
