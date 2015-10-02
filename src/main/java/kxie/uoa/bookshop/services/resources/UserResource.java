package kxie.uoa.bookshop.services.resources;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import kxie.uoa.bookshop.domain.Order;
import kxie.uoa.bookshop.domain.User;
import kxie.uoa.bookshop.dto.OrderDto;
import kxie.uoa.bookshop.dto.UserDto;
import kxie.uoa.bookshop.services.mappers.OrderMapper;
import kxie.uoa.bookshop.services.mappers.UserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Web service resource implementation for the User application. An instance of
 * this class handles all HTTP requests for the User Web service.
 * 
 * @author kxie094
 * 
 */
@Path("/users")
public class UserResource {
	private static final Logger _logger = LoggerFactory.getLogger(UserResource.class);

	private EntityManager em;

	public UserResource() {
		em = Persistence.createEntityManagerFactory("bookShopPU").createEntityManager();
	}

	/**
	 * Adds a new User to the system. The state of the new User is described by
	 * a kxie.uoa.bookshop.dto.UserDto object.
	 * 
	 * @param userDto
	 *            - the User data included in the HTTP request body.
	 */
	@POST
	@Consumes("application/xml")
	public Response createUser(UserDto userDto) {
		_logger.debug("Read user: " + userDto);
		
		// Get the full user
		User user = UserMapper.toDomainModel(userDto);
		
		// Persist in DB
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		_logger.debug("Created user: " + user);
		return Response.created(URI.create("/users/" + user.getId())).build();
	}

	/**
	 * Returns a particular User. The returned User is represented by a UserDto
	 * object.
	 * 
	 * @param id
	 *            - the unique identifier of the User.
	 */
	@GET
	@Path("{id}")
	@Produces("application/xml")
	public UserDto getUser(@PathParam("id") long id) {
		// Get the full User object from the database.
		User user = em.find(User.class, id);

		// Convert the full User a short User.
		UserDto userDto = UserMapper.toDto(user);

		return userDto;
	}

	/**
	 * Updates a User's order history.
	 * 
	 * @param id
	 *            the unique identifier of the User.
	 * @param order
	 *            the User's order to add to their history.
	 */
	@PUT
	@Path("{id}/orders")
	@Consumes("application/xml")
	public void updateOrderHistory(@PathParam("id") long id, OrderDto orderDto) {
		// Get the full User object from the database.
		User user = em.find(User.class, id);

		Order fullOrder = OrderMapper.toDomainModel(orderDto);

		// Update the user's order history.
		user.addOrder(fullOrder);
	}
	
	/**
	 * Sets a cookie when a user logs in.
	 */
	@GET
	@Path("{id}/login")
	@Produces(MediaType.TEXT_PLAIN)
	public Response login(@PathParam("id") long id, UserDto userDto) {
	    NewCookie cookie = new NewCookie(userDto.getUsername(), userDto.getPassword());
	    return Response.ok("OK").cookie(cookie).build();
	}
	
	/**
	 * Removes cookie when user logs out.
	 */
	@GET
	@Path("/logout")
	@Produces(MediaType.TEXT_PLAIN)
	public Response logout(@CookieParam("id") Cookie cookie) {
	    if (cookie != null) {
	        NewCookie newCookie = new NewCookie(cookie, null, 0, false);
	        return Response.ok("OK").cookie(newCookie).build();
	    }
	    return Response.ok("OK - No session").build();
	}

}
