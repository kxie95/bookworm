package kxie.uoa.bookshop.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Order {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User orderee;

	@Column
	private double totalCost;

	@ElementCollection
	@CollectionTable(name = "BOOK_ORDERS")
	private Set<BookOrder> booksOrdered = new HashSet<BookOrder>();

	@Temporal(TemporalType.DATE)
	private Date dateOrdered;

	@Column
	private OrderStatus orderStatus;
	
	@Column
	private PaymentMethod paymentMethod;

	@Column
	private ShippingMethod shippingMethod;

	protected Order() {
	}

	/**
	 * Constructor for Order instance. Id assigned by database.
	 */
	public Order(User orderee, 
			double totalCost, 
			Set<BookOrder> booksOrdered, 
			Date dateOrdered, 
			PaymentMethod paymentMethod, 
			ShippingMethod shippingMethod,
			OrderStatus orderStatus) {
		this.orderee = orderee;
		this.totalCost = totalCost;
		this.booksOrdered = booksOrdered;
		this.dateOrdered = dateOrdered;
		this.paymentMethod = paymentMethod;
		this.shippingMethod = shippingMethod;
		this.orderStatus = orderStatus;
	}

	// Getters and Setters
	public Long getId() {return id;}

	public double getTotalCost() {return totalCost;}
	
	public void setTotalCost(double totalCost) {this.totalCost = totalCost;}
	
	public Set<BookOrder> getBooksOrdered() {return booksOrdered;}

	public void setBooksOrdered(Set<BookOrder> booksOrdered) {this.booksOrdered = booksOrdered;}
	
	public User getOrderee() {return orderee;}

	public void setOrderee(User orderee) {this.orderee = orderee;}

	public PaymentMethod getPaymentMethod() {return paymentMethod;}

	public void setPaymentMethod(PaymentMethod paymentMethod) {this.paymentMethod = paymentMethod;}

	public Date getDateOrdered() {return dateOrdered;}

	public void setDateOrdered(Date date) {this.dateOrdered = date;}

	public OrderStatus getOrderStatus() {return orderStatus;}

	public void setOrderStatus(OrderStatus orderStatus) {this.orderStatus = orderStatus;}

	public ShippingMethod getShippingMethod() {return shippingMethod;}

	public void setShippingMethod(ShippingMethod shippingMethod) {this.shippingMethod = shippingMethod;}

	
}
