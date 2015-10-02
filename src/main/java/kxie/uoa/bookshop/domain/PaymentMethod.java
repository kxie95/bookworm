package kxie.uoa.bookshop.domain;

/**
 * Enum class representing the payment method used to pay for an order.
 * @author Karen Xie, kxie094
 *
 */
public enum PaymentMethod {
	CREDIT_CARD("Credit Card"), PAYPAL("Paypal"), BANK_TRANSFER("Bank Transfer");
	
	private final String method;
	
	private PaymentMethod(String method) {
		this.method = method;
	}
	
	public String getMethod() {
		return method;
	}
	
	public static PaymentMethod fromString(String text) {
	    if (text != null) {
	      for (PaymentMethod pm : PaymentMethod.values()) {
	        if (text.equalsIgnoreCase(pm.method)) {
	          return pm;
	        }
	      }
	    }
	    return null;
	  }
}
