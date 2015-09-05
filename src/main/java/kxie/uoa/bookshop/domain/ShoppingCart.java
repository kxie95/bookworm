package kxie.uoa.bookshop.domain;

import java.util.HashMap;

public class ShoppingCart {
	private HashMap<Book, Integer> _booksInCart;
	
	public void addToCart(Book book, int quantity) {
		_booksInCart.put(book, quantity);
	}
	
	public HashMap<Book, Integer> getBooksInCart() {
		return _booksInCart;
	}
	
	public double getTotalPrice() {
		double total = 0;
		for (Book book : _booksInCart.keySet()) {
			total += book.get_price();
		}
		return total;
	}
}
