package kxie.uoa.bookshop.services.mappers;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import kxie.uoa.bookshop.domain.Book;
import kxie.uoa.bookshop.domain.Review;
import kxie.uoa.bookshop.domain.User;
import kxie.uoa.bookshop.dto.ReviewDto;

public class ReviewMapper {
	
	private static EntityManager em = Persistence.createEntityManagerFactory("bookShopPU").createEntityManager();
	
	public static Review toDomainModel(ReviewDto reviewDto) {
		em.getTransaction().begin();
		Book book = em.find(Book.class, reviewDto.getBookId());
		User reviewer = em.find(User.class, reviewDto.getUserId());
		em.getTransaction().commit();
		
		Review fullReview = new Review(reviewer, book, reviewDto.getComment());

		return fullReview;
	}

	public static ReviewDto toDto(Review review) {
		ReviewDto reviewDto = new ReviewDto(
				review.getId(), 
				review.getReviewer().getId(), 
				review.getComment());
		return reviewDto;

	}
}
