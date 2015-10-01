package kxie.uoa.bookshop.services.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import kxie.uoa.bookshop.dto.ReviewDto;

/**
 * Service interface for the reviewShop application. Allows reviews
 * to be created, queried (by Id) and updated.
 * @author Karen Xie kxie094, based on the template from Ian Warren.
 *
 */
@Path("/reviews")
public interface ReviewResource {
	/**
	 * Handles incoming HTTP POST requests for the relative URI "reviews", 
	 * This method creates new reviews.
	 * @param reviewDto representing the review domain class.
	 * @return a JAX-RS Response object that the JAX-RS implementation uses to
	 * prepare the HTTP response message.
	 */
   @POST
   @Consumes("application/xml")
   Response createReview(ReviewDto reviewDto);

   /**
    * Handles incoming HTTP GET requests for the relative URI "reviews/{id}.
    * @param id the unique id of the review to retrieve.
    * @return reviewDto representing the review domain class.
    */
   @GET
   @Path("{id}")
   @Produces("application/xml")
   ReviewDto retrieveReview(@PathParam("id") long id);

   /**
    * Handles incoming HTTP PUT requests for the relative URI "reviews/{id}.
    * @param id the unique id of the review to retrieve.
    * @param reviewDto the dto class representing the review domain class.
    */
   @PUT
   @Path("{id}")
   @Consumes("application/xml")
   void updateReview(@PathParam("id") long id, ReviewDto reviewDto);
}
