package kxie.uoa.bookshop.domain;

import java.util.HashMap;

public class ShoppingCart {
	private HashMap<Book, Integer> _booksInCart;
	
	public HashMap<Book, Integer> getBooksInCart() {
		return _booksInCart;
	}

	public void set_booksInCart(HashMap<Book, Integer> booksInCart) {
		_booksInCart = booksInCart;
	}
}
