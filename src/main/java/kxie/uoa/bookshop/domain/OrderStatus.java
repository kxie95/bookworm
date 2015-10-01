package kxie.uoa.bookshop.domain;

public enum OrderStatus {
	PROCESSING("Processing"), SENT("Sent"), DELIVERED("Delivered");
	
	private final String status;
	
	private OrderStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public static OrderStatus fromString(String text) {
	    if (text != null) {
	      for (OrderStatus os : OrderStatus.values()) {
	        if (text.equalsIgnoreCase(os.status)) {
	          return os;
	        }
	      }
	    }
	    return null;
	  }
}
