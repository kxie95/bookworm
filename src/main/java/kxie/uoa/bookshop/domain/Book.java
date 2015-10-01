package kxie.uoa.bookshop.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * Class representing a book product.
 * 
 * @author Karen Xie, kxie094
 * 
 */
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String author;

	@JoinTable(name = "BOOK_GENRE", joinColumns = @JoinColumn(name = "book_id", nullable = false))
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Genre genre;

	@Column(nullable = false)
	private double price;

	@OneToMany(mappedBy="book", fetch = FetchType.LAZY)
	private List<Review> reviews;

	protected Book() {
	}

	/**
	 * Constructor for Book instance. Id set by database.
	 */
	public Book(String title, String author, Genre genre, double price) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
	}

	public Long getId() {return id;}

	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}

	public String getAuthor() {return author;}

	public void setAuthor(String author) {this.author = author;}

	public double getPrice() {return price;}

	public void setPrice(double price) {this.price = price;}

	public List<Review> getReviews() {return reviews;}

	public void setReviews(List<Review> reviews) {this.reviews = reviews;}

	public Genre getGenre() {return genre;}

	public void setGenre(Genre genre) {this.genre = genre;}

}
