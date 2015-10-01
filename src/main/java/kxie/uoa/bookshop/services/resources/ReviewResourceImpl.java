package kxie.uoa.bookshop.services.resources;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;

import kxie.uoa.bookshop.domain.Review;
import kxie.uoa.bookshop.dto.ReviewDto;
import kxie.uoa.bookshop.services.mappers.ReviewMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReviewResourceImpl implements ReviewResource {

	private static final Logger _logger = LoggerFactory.getLogger(ReviewResourceImpl.class);

	private EntityManager em;
	
	public ReviewResourceImpl() {
		em = Persistence.createEntityManagerFactory("bookShopPU").createEntityManager();
	}
	
	@Override
	public Response createReview(ReviewDto reviewDto) {
		_logger.debug("Read book: " + reviewDto);
		
		// Get the full review
		Review review = ReviewMapper.toDomainModel(reviewDto);
		
		// Persist in DB
		em.getTransaction().begin();
		em.persist(review);
		em.getTransaction().commit();

		_logger.debug("Created book: " + review);
		return Response.created(URI.create("/books/" + review.getId())).build();
	}

	@Override
	public ReviewDto retrieveReview(long id) {
		// Get the full User object from the database.
		Review review = em.find(Review.class, id);

		// Convert the full User a short User.
		ReviewDto reviewDto = ReviewMapper.toDto(review);

		return reviewDto;
	}

	@Override
	public void updateReview(long id, ReviewDto reviewDto) {
		// TODO Auto-generated method stub
		
	}

}
