package kxie.uoa.bookshop.domain;

public enum Genre {

	COMEDY("Comedy"), DRAMA("Drama"), NON_FICTION("Non fiction"), REALISTIC_FICTION("Realistic fiction"), ROMANCE("Romance"), SATIRE("Satire"), TRAGEDY("Tragedy");
	
	private final String description;
	
	private Genre(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
