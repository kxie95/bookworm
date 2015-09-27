package kxie.uoa.bookshop.domain;

public class Review {
	private User _reviewer;
	private String _comment;
	private Rating _rating;
	
	public enum Rating {
		TERRIBLE(1), POOR(2), AVERAGE(3), GOOD(4), EXCELLENT(5);
		private final int _value;

		private Rating(int value) {
			_value = value;
		}
		
		public int getValue() {
			return _value;
		}
	}
	
	public User getReviewer() {
		return _reviewer;
	}
	
	public void setReviewer(User reviewer) {
		_reviewer = reviewer;
	}
	
	public String getComment() {
		return _comment;
	}
	
	public void setComment(String comment) {
		_comment = comment;
	}
	
	public Rating getRating() {
		return _rating;
	}
	
	public void setRating(Rating rating) {
		_rating = rating;
	}
}
