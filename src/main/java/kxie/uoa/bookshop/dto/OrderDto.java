package kxie.uoa.bookshop.dto;

import java.util.Date;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import kxie.uoa.bookshop.domain.BookOrder;

@XmlRootElement(name = "order")
public class OrderDto {

	@XmlAttribute(name = "id")
	private Long _id;

	@XmlElement(name = "total")
	private double _totalCost;

	@XmlElement(name = "date-ordered")
	private Date _dateOrdered;

	@XmlElement(name = "order-status")
	private String _orderStatus;

	@XmlElement(name = "shipping-method")
	private String _shippingMethod;

	@XmlElement(name = "payment")
	private String _paymentMethod;

	@XmlElement(name = "books-ordered")
	private HashSet<BookOrder> _booksOrdered;

	private String _customerName;

	private OrderDto() {
	}

	public OrderDto(long id, double totalCost, HashSet<BookOrder> booksOrdered, String shippingMethod, String paymentMethod) {
		_id = id;
		_totalCost = totalCost;
		_booksOrdered = booksOrdered;
		_dateOrdered = new Date();
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

	public HashSet<BookOrder> getBooksOrdered() {
		return _booksOrdered;
	}

	public void setBooksOrdered(HashSet<BookOrder> booksOrdered) {
		_booksOrdered = booksOrdered;
	}

	public Date getDateOrdered() {
		return _dateOrdered;
	}

	public void setDateOrdered() {
		_dateOrdered = new Date();
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
