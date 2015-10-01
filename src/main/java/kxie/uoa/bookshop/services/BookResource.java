package kxie.uoa.bookshop.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import kxie.uoa.bookshop.dto.BookDto;

/**
 * Service interface for the Parolees application. This interface allows 
 * Parolees to be created, queried (by id) and updated.
 * 
 * @author Ian Warren
 *
 */
@Path("/books")
public interface BookResource {

	/**
	 * Handles incoming HTTP POST requests for the relative URI "books", 
	 * This method creates new Books.
	 * @param bookDto representing the Book domain class.
	 * @return a JAX-RS Response object that the JAX-RS implementation uses to
	 * prepare the HTTP response message.
	 */
   @POST
   @Consumes("application/xml")
   Response createBook(BookDto bookDto);

   /**
    * Handles incoming HTTP GET requests for the relative URI "books/{id}.
    * @param id the unique id of the Book to retrieve.
    * @return bookDto representing the Book domain class.
    */
   @GET
   @Path("{id}")
   @Produces("application/xml")
   BookDto retrieveBook(@PathParam("id") long id);

   /**
    * Handles incoming HTTP PUT requests for the relative URI "books/{id}.
    * @param id the unique id of the Book to retrieve.
    * @param bookDto the dto class representing the Book domain class.
    */
   @PUT
   @Path("{id}")
   @Consumes("application/xml")
   void updateBook(@PathParam("id") long id, BookDto bookDto);
}

