package kxie.uoa.bookshop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing the number of books ordered.
 *
 * @author Karen Xie kxie094
 *
 */
@XmlRootElement(name = "book-quantity")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class BookOrder {

	@OneToOne
	@JoinColumn(name = "BOOK_ID")
	@XmlElement(name = "book-id")
	private Book book;
	
	@Column(nullable = false)
	@XmlElement(name = "quantity")
	private int quantity;
	
	protected BookOrder() {}
	
	public BookOrder(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}

	public Book getBook() {return book;}
	
	public void setBook(Book book) {this.book = book;}
	
	public int getQuantity() {return quantity;}
	
	public void setQuantity(int quantity) {this.quantity = quantity;}
}
