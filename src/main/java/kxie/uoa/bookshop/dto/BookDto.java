package kxie.uoa.bookshop.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class BookDto {
	@XmlAttribute(name = "book-id")
	private Long _id;

	@XmlElement(name = "title")
	private String _title;

	@XmlElement(name = "author")
	private String _author;

	@XmlElement(name = "price")
	private double _price;

	/**
	 * Used for Book-BookDto mapping.
	 */
	public BookDto(long id, String title, String author, double price) {
		_id = id;
		_title = title;
		_author = author;
		_price = price;
	}

	public Long getId() {
		return _id;
	}

	public void setId(Long id) {
		_id = id;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public double get_price() {
		return _price;
	}

	public void set_price(double _price) {
		this._price = _price;
	}
}
