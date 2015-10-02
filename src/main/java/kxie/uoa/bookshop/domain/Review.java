package kxie.uoa.bookshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Class representing a review for a book by a user.
 * @author Karen Xie kxie094
 *
 */
@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User reviewer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOK_ID", nullable = false)
	private Book book;
	
	@Column(nullable = false)
	private String comment;
	
	protected Review() {}
	
	/**
	 * Constructor for Review instance. Id set by database.
	 */
	public Review(User reviewer, Book book, String comment) {
		this.reviewer = reviewer;
		this.book = book;
		this.comment = comment;
	}
	
	// Getters and Setters
	
	public Long getId() {return id;}

	public void setId(Long id) {this.id = id;}

	public User getReviewer() {return reviewer;}

	public void setReviewer(User reviewer) {this.reviewer = reviewer;}
	
	public String getComment() {return comment;}
	
	public void setComment(String comment) {this.comment = comment;}

	public Book getBook() {return book;}

	public void setBook(Book book) {this.book = book;}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Review) {return true;}
		
		if ( obj == this ) {return true;}
		
		return false;
	}
	
	 @Override
	 public int hashCode( ) {
		 return new HashCodeBuilder( 17, 31 )
		 .append(reviewer.getUsername())
		 .append(reviewer.getUsername()).toHashCode( );
	 }

}
