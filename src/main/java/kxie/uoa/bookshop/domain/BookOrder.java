package kxie.uoa.bookshop.domain;

/**
 * Class representing the number of books ordered.
 *
 * @author Karen Xie kxie094
 *
 */
public class BookOrder {

	private Book book;
	private int quantity;
	
	public Book getBook() {return book;}
	
	public void setBook(Book book) {this.book = book;}
	
	public int getQuantity() {return quantity;}
	
	public void setQuantity(int quantity) {this.quantity = quantity;}
}
