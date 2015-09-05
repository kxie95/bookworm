package kxie.uoa.bookshop.domain;

import java.util.HashMap;

public class ShoppingCart {
	private HashMap<Book, Integer> _booksInCart;
	private double _totalPrice;
	
	public void addToCart(Book book, int quantity) {
		_booksInCart.put(book, quantity);
	}
	
	public HashMap<Book, Integer> getBooksInCart() {
		return _booksInCart;
	}
	
	public void getTotalPrice() {
	}
}
