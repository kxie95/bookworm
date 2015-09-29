package kxie.uoa.bookshop.domain;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Order {
	public enum PaymentMethod {
		CREDIT_CARD, BANK_TRANSFER, PAYPAL;

		public static PaymentMethod fromString(String text) {
			if (text.equalsIgnoreCase(BANK_TRANSFER.toString())) {
				return PaymentMethod.BANK_TRANSFER;
			} else if (text.equalsIgnoreCase(CREDIT_CARD.toString())) {
				return PaymentMethod.CREDIT_CARD;
			} else if (text.equalsIgnoreCase(PAYPAL.toString())) {
				return PaymentMethod.PAYPAL;
			}
			return null;
		}
	}

	public enum OrderStatus {
		PROCESSING, DISPATCHED, RECEIVED;

		public static OrderStatus fromString(String text) {
			if (text.equalsIgnoreCase(PROCESSING.toString())) {
				return OrderStatus.PROCESSING;
			} else if (text.equalsIgnoreCase(DISPATCHED.toString())) {
				return OrderStatus.DISPATCHED;
			} else if (text.equalsIgnoreCase(RECEIVED.toString())) {
				return OrderStatus.RECEIVED;
			}
			return null;
		}
	}

	public enum ShippingMethod {
		STANDARD, EXPRESS;

		public static ShippingMethod fromString(String text) {
			if (text.equalsIgnoreCase(STANDARD.toString())) {
				return ShippingMethod.STANDARD;
			} else if (text.equalsIgnoreCase(EXPRESS.toString())) {
				return ShippingMethod.EXPRESS;
			}
			return null;
		}
	}

	@Id
	@Column(name = "ADDR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;

	@Column(name = "ORDER_TOTAL")
	private double _totalCost;

	@Column(name = "PAYMENT_METHOD")
	private PaymentMethod _paymentMethod;

	private HashSet<BookOrder> _booksOrdered;

	@Temporal(TemporalType.DATE)
	private Date _dateOrdered;

	private OrderStatus _orderStatus;

	private ShippingMethod _shippingMethod;

	@Column(name = "CUSTOMER")
	private String _customerName;

	public Order() {
	}

	public Order(long id, double totalCost, HashSet<BookOrder> booksOrdered, Date dateOrdered, ShippingMethod shippingMethod,
			PaymentMethod paymentMethod) {
		_id = id;
		_totalCost = totalCost;
		_booksOrdered = booksOrdered;
		_dateOrdered = dateOrdered;
		_orderStatus = OrderStatus.PROCESSING;
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

	public PaymentMethod getPaymentMethod() {
		return _paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
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
