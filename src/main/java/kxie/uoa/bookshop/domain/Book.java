package kxie.uoa.bookshop.domain;

/**
 * Bean class to represent a Book product.
 * 
 * @author Karen Xie, kxie094
 *
 */
public class Book {
	private int _id;
	private String _title;
	private String _author;
	private Genre _genre;
	private double _price;
	
	public enum Genre {
		FICTION, NON_FICTION;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int id) {
		_id = id;
	}

	public String get_title() {
		return _title;
	}

	public void set_title(String title) {
		_title = title;
	}

	public String get_author() {
		return _author;
	}

	public void set_author(String author) {
		_author = author;
	}

	public Genre get_genre() {
		return _genre;
	}

	public void set_genre(Genre genre) {
		_genre = genre;
	}
	
	public double get_price() {
		return _price;
	}
	
	public void set_price(double price) {
		_price = price;
	}
}