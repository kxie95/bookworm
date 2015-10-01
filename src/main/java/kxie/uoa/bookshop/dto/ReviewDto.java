package kxie.uoa.bookshop.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing a review. Used by the web service to send data.
 * @author Karen Xie kxie094
 *
 */
@XmlRootElement(name="review")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReviewDto {

	@XmlAttribute(name = "id")
	private long id;
	
	@XmlElement(name = "userId")
	private long userId;
	
	@XmlElement(name = "bookId")
	private long bookId;
	
	@XmlElement(name = "comment")
	private String comment;
	
	/**Required by JAXB */
	protected ReviewDto() {}
	
	/**
	 * Constructs a DTO User instance. This method is intended to be called by
	 * Web service clients when creating new Users.
	 */
	public ReviewDto(long userId, long bookId, String comment) throws IllegalArgumentException {
		this(0, userId, bookId, comment);
	}

	/**
	 * Constructs a DTO Review instance. This method is intended to be called by
	 * Web service clients when creating new Review.
	 */
	public ReviewDto(long reviewId, long userId, long bookId, String comment) {
		this.id = reviewId;
		this.userId = userId;
		this.bookId = bookId;
		this.comment = comment;
	}

	// Getters and Setters
	public long getId() {return id;}

	public void setId(long id) {this.id = id;}
	
	public long getUserId() {return userId;}
	
	public void setUserId(long userId) {this.userId = userId;}
	
	public long getBookId() {return bookId;}
	
	public void setBookId(long bookId) {this.bookId = bookId;}
	
	public String getComment() {return comment;}
	
	public void setComment(String comment) {this.comment = comment;}

}
