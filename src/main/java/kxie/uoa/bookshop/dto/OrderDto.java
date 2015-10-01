package kxie.uoa.bookshop.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import kxie.uoa.bookshop.adapters.DateAdapter;
import kxie.uoa.bookshop.domain.BookOrder;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDto {

	@XmlAttribute(name = "id")
	private long id;
	
	@XmlElement(name = "orderee")
	private long orderee;

	@XmlElement(name = "total")
	private double totalCost;

	@XmlElement(name = "booksOrdered")
	private Set<BookOrder> booksOrdered = new HashSet<BookOrder>();

	@XmlElement(name = "dateOrdered")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOrdered;

	@XmlElement(name = "orderStatus")
	private String orderStatus;
	
	@XmlElement(name = "paymentMethod")
	private String paymentMethod;

	@XmlElement(name = "shippingMethod")
	private String shippingMethod;

	protected OrderDto() {
	}

	public OrderDto(long orderee, double totalCost, Set<BookOrder> booksOrdered, Date dateOrdered, String shippingMethod, String paymentMethod, String orderStatus) {
		this(0, orderee, totalCost, booksOrdered, dateOrdered, shippingMethod, paymentMethod, orderStatus);
	}
	
	/**
	 * Constructor for OrderDto instance.
	 */
	public OrderDto(long id, long orderee, double totalCost, Set<BookOrder> booksOrdered, Date dateOrdered, String shippingMethod, String paymentMethod, String orderStatus) {
		this.id = id;
		this.orderee = orderee;
		this.totalCost = totalCost;
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
	
	public long getOrderee() {return orderee;}

	public void setOrderee(long orderee) {this.orderee = orderee;}

	public String getPaymentMethod() {return paymentMethod;}

	public void setPaymentMethod(String paymentMethod) {this.paymentMethod = paymentMethod;}

	public Date getDateOrdered() {return dateOrdered;}

	public void setDateOrdered(Date date) {this.dateOrdered = date;}

	public String getOrderStatus() {return orderStatus;}

	public void setOrderStatus(String orderStatus) {this.orderStatus = orderStatus;}

	public String getShippingMethod() {return shippingMethod;}

	public void setShippingMethod(String shippingMethod) {this.shippingMethod = shippingMethod;}

}
