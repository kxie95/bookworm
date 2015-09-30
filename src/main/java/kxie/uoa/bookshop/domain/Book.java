package kxie.uoa.bookshop.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

/**
 * Bean class to represent a Book product.
 * 
 * @author Karen Xie, kxie094
 * 
 */
public class Book {
	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;

	@Column(name = "TITLE")
	private String _title;

	@Column(name = "AUTHOR")
	private String _author;

	@Column(name = "ISBN")
	private String _isbn;

	@Column(name = "GENRE")
	private String _genre;

	@Column(name = "PRICE")
	private double _price;

	@OrderColumn(name = "REVIEW_ORDER")
	private List<Review> _reviews;

	public Book() {
	}

	/**
	 * Constructor for BookDto-Book mapping.
	 */
	public Book(long id, String title, String author, double price) {
		_id = id;
		_title = title;
		_author = author;
		_price = price;
	}

	public Long getId() {
		return _id;
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

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public List<Review> getReviews() {
		return _reviews;
	}

	public void setReviews(List<Review> reviews) {
		_reviews = reviews;
	}

	public String getGenre() {
		return _genre;
	}

	public void setGenre(String genre) {
		_genre = genre;
	}

	public String getIsbn() {
		return _isbn;
	}

	public void setIsbn(String isbn) {
		_isbn = isbn;
	}
}