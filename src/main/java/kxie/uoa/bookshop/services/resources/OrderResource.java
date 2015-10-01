package kxie.uoa.bookshop.services.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import kxie.uoa.bookshop.dto.OrderDto;

@Path("/orders")
public interface OrderResource {

		/**
		 * Handles incoming HTTP POST requests for the relative URI "orders", 
		 * This method creates new Orders.
		 * @param orderDto representing the Order domain class.
		 * @return a JAX-RS Response object that the JAX-RS implementation uses to
		 * prepare the HTTP response message.
		 */
	   @POST
	   @Consumes("application/xml")
	   Response createOrder(OrderDto orderDto);

	   /**
	    * Handles incoming HTTP GET requests for the relative URI "orders/{id}.
	    * @param id the unique id of the Order to retrieve.
	    * @return orderkDto representing the Order domain class.
	    */
	   @GET
	   @Path("{id}")
	   @Produces("application/xml")
	   OrderDto retrieveOrder(@PathParam("id") long id);

	   /**
	    * Handles incoming HTTP PUT requests for the relative URI "order/{id}.
	    * @param id the unique id of the Order to retrieve.
	    * @param bookDto the dto class representing the Order domain class.
	    */
	   @PUT
	   @Path("{id}")
	   @Consumes("application/xml")
	   void updateOrder(@PathParam("id") long id, OrderDto orderDto);
}
