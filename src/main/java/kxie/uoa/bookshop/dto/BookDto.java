package kxie.uoa.bookshop.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookDto {
	@XmlAttribute(name = "id")
	private long id;

	@XmlElement(name = "title")
	private String title;

	@XmlElement(name = "author")
	private String author;

	@XmlElement(name = "genre")
	private String genre;

	@XmlElement(name = "price")
	private double price;

	protected BookDto() {
	}
	
	/**
	 * Constructs a DTO User instance. This method is intended to be called by
	 * Web service clients when creating new Users.
	 */
	public BookDto(String title, String author, String genre, double price) throws IllegalArgumentException {
		this(0, title, author, genre, price);
	}

	/**
	 * Constructs a DTO User instance. It is intended to be used by the Web
	 * Service implementation when creating a DTO User from a domain-model User
	 * object.
	 */
	public BookDto(long id, String title, String author, String genre, double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
	}

	// Getters and Setters
	public Long getId() {return id;}

	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}

	public String getAuthor() {return author;}

	public void setAuthor(String author) {this.author = author;}

	public double getPrice() {return price;}

	public void setPrice(double price) {this.price = price;}

	public String getGenre() {return genre;}

	public void setGenre(String genre) {this.genre = genre;}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BookDto))
			return false;
		if (obj == this)
			return true;

		BookDto rhs = (BookDto) obj;
		return new EqualsBuilder().append(id, rhs.id).append(title, rhs.title).append(author, rhs.author)
				.append(genre, rhs.genre).append(price, rhs.price).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(id).toHashCode();
	}
}
