package kxie.uoa.bookshop.domain;


public enum Genre {

	COMEDY("Comedy"), DRAMA("Drama"), NOVEL("Novel"), NON_FICTION("Non fiction"), REALISTIC_FICTION("Realistic fiction"), ROMANCE("Romance"), SATIRE("Satire"), TRAGEDY("Tragedy");
	
	private final String description;
	
	private Genre(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Genre fromString(String text) {
	    if (text != null) {
	      for (Genre g : Genre.values()) {
	        if (text.equalsIgnoreCase(g.description)) {
	          return g;
	        }
	      }
	    }
	    return null;
	  }
}
