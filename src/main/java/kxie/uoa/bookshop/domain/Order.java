package kxie.uoa.bookshop.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

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
	
	private long _id;
	private double _totalCost;
	private PaymentMethod _paymentMethod;
	private HashMap<Book, Integer> _booksOrdered;
	private Calendar _dateOrdered;
	private OrderStatus _orderStatus;
	private ShippingMethod _shippingMethod;
	private Address _shippingAddress;
	private String _customerName;
	
	public long getId() {
		return _id;
	}
	public void setId(long id) {
		_id = id;
	}
	public double getTotalCost() {
		return _totalCost;
	}
	public void set_totalCost(double totalCost) {
		_totalCost = totalCost;
	}
	public PaymentMethod getPaymentMethod() {
		return _paymentMethod;
	}
	public void set_paymentMethod(PaymentMethod paymentMethod) {
		_paymentMethod = paymentMethod;
	}
	public HashMap<Book, Integer> getBooksOrdered() {
		return _booksOrdered;
	}
	public void set_booksOrdered(HashMap<Book, Integer> booksOrdered) {
		_booksOrdered = booksOrdered;
	}
	public Calendar getDateOrdered() {
		return _dateOrdered;
	}
	public void setDateOrdered(int year, int month, int day) {
		Calendar date = new GregorianCalendar();
		date.set(year, month, day);
		_dateOrdered = date;
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
	public Address getShippingAddress() {
		return _shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		_shippingAddress = shippingAddress;
	}
	public String getCustomerName() {
		return _customerName;
	}
	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}
}
