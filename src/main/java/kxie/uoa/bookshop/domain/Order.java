package kxie.uoa.bookshop.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Order {
	public enum PaymentMethod {
		CREDIT_CARD, BANK_TRANSFER, PAYPAL;
	}
	
	public enum OrderStatus {
		PROCESSING, DISPATCHED, RECEIVED;
	}
	
	public enum ShippingMethod {
		STANDARD, EXPRESS;
	}
	
	@Id
	@Column(name="ADDR_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long _id;
	
	@Column(name="ORDER_TOTAL")
	private double _totalCost;
	
	@Column(name="PAYMENT_METHOD")
	private PaymentMethod _paymentMethod;
	
	private HashMap<Book, Integer> _booksOrdered;
	
	@Temporal(TemporalType.DATE)
	private Date _dateOrdered;
	
	private OrderStatus _orderStatus;
	
	private ShippingMethod _shippingMethod;
	
	@Column(name="CUSTOMER")
	private String _customerName;
	
	public long getId() {
		return _id;
	}
	
	public double getTotalCost() {
		return _totalCost;
	}
	
	public void setTotalCost(double totalCost) {
		_totalCost = totalCost;
	}
	
	public PaymentMethod getPaymentMethod() {
		return _paymentMethod;
	}
	
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		_paymentMethod = paymentMethod;
	}
	
	public HashMap<Book, Integer> getBooksOrdered() {
		return _booksOrdered;
	}
	
	public void setBooksOrdered(HashMap<Book, Integer> booksOrdered) {
		_booksOrdered = booksOrdered;
	}
	
	public Date getDateOrdered() {
		return _dateOrdered;
	}
	
	public void setDateOrdered() {
		_dateOrdered = new Date();
	}
	
	public OrderStatus getOrderStatus() {
		return _orderStatus;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		_orderStatus = orderStatus;
	}
	
	public ShippingMethod getShippingMethod() {
		return _shippingMethod;
	}
	
	public void setShippingMethod(ShippingMethod shippingMethod) {
		_shippingMethod = shippingMethod;
	}
	
	public String getCustomerName() {
		return _customerName;
	}
	
	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}
}
