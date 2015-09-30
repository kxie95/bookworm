package kxie.uoa.bookshop.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDto {

	@XmlAttribute(name = "id")
	private Long _id;

	@XmlElement(name = "total")
	private double _totalCost;

	@XmlElement(name = "date-ordered")
	private String _dateOrdered;

	@XmlElement(name = "order-status")
	private String _orderStatus;

	@XmlElement(name = "shipping-method")
	private String _shippingMethod;

	@XmlElement(name = "payment")
	private String _paymentMethod;

	@XmlElement(name = "name")
	private String _customerName;

	private OrderDto() {
	}

	/**
	 * Constructor for OrderDto.
	 * 
	 * @param id
	 * @param totalCost
	 * @param booksOrdered
	 * @param shippingMethod
	 * @param paymentMethod
	 */
	public OrderDto(long id, double totalCost, String dateOrdered, String customerName, String shippingMethod, String paymentMethod) {
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
