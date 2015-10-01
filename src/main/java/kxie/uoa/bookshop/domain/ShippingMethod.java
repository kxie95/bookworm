package kxie.uoa.bookshop.domain;

public enum ShippingMethod {
	EXPRESS("Express"), STANDARD("Standard");
	
	private final String method;
	
	private ShippingMethod(String method) {
		this.method = method;
	}
	
	public String getMethod() {
		return method;
	}
	
	public static ShippingMethod fromString(String text) {
	    if (text != null) {
	      for (ShippingMethod sm : ShippingMethod.values()) {
	        if (text.equalsIgnoreCase(sm.method)) {
	          return sm;
	        }
	      }
	    }
	    return null;
	  }
}
