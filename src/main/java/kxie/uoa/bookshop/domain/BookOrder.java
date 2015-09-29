package kxie.uoa.bookshop.domain;

import javax.xml.bind.annotation.XmlElement;

public class BookOrder {
	@XmlElement(name = "isbn")
	private String _isbn;

	@XmlElement(name = "quantity")
	private int _quantity;

	private BookOrder() {

	}

	public BookOrder(String isbn, int quantity) {
		_isbn = isbn;
		_quantity = quantity;
	}

	public String getBookISBN() {
		return _isbn;
	}

	public void setBook(String isbn) {
		_isbn = isbn;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}
}
