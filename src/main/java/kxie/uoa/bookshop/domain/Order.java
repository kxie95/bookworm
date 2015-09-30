package kxie.uoa.bookshop.domain;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

public class Order {
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;

	@Column(name = "ORDER_TOTAL")
	private double _totalCost;

	@Column(name = "PAYMENT_METHOD")
	private String _paymentMethod;

	@MapKeyColumn(name = "BOOK")
	@Column(name = "QUANTITY")
	private HashMap<Book, Integer> _booksOrdered;

	@Column(name = "DATE")
	private String _dateOrdered;

	@Column(name = "ORDER_STATUS")
	private String _orderStatus;

	@Column(name = "SHIPPING_METHOD")
	private String _shippingMethod;

	@Column(name = "CUSTOMER")
	private String _customerName;

	public Order() {
	}

	/**
	 * Used for dto-order mapping.
	 * 
	 * @param id
	 * @param totalCost
	 * @param customerName
	 * @param dateOrdered
	 * @param shippingMethod
	 * @param paymentMethod
	 */
	public Order(long id, double totalCost, String customerName, String dateOrdered, String shippingMethod, String paymentMethod) {
		_id = id;
		_totalCost = totalCost;
		_customerName = customerName;
		_dateOrdered = dateOrdered;
		_orderStatus = "Processing";
		_shippingMethod = shippingMethod;
		_paymentMethod = paymentMethod;
	}

	public long getId() {
		return _id;
	}

	public double getTotalCost() {
		return _totalCost;
	}

	public void setTotalCost(double totalCost) {
		_totalCost = totalCost;
	}

	public String getPaymentMethod() {
		return _paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		_paymentMethod = paymentMethod;
	}

	public HashMap<Book, Integer> getBooksOrdered() {
		return _booksOrdered;
	}

	public void setBooksOrdered(HashMap<Book, Integer> booksOrdered) {
		_booksOrdered = booksOrdered;
	}

	public String getDateOrdered() {
		return _dateOrdered;
	}

	public void setDateOrdered(Date date) {
		_dateOrdered = date.toString();
	}

	public String getOrderStatus() {
		return _orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		_orderStatus = orderStatus;
	}

	public String getShippingMethod() {
		return _shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		_shippingMethod = shippingMethod;
	}

	public String getCustomerName() {
		return _customerName;
	}

	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}
}
