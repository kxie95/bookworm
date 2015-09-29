package kxie.uoa.bookshop.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import kxie.uoa.bookshop.domain.Book;
import kxie.uoa.bookshop.domain.Order;
import kxie.uoa.bookshop.domain.Order.PaymentMethod;
import kxie.uoa.bookshop.domain.Order.ShippingMethod;
import kxie.uoa.bookshop.domain.User;
import kxie.uoa.bookshop.dto.UserDto;

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

	private Map<Long, User> _userDB;
	private AtomicLong _idCounter = new AtomicLong();

	public UserResource() {
		reloadDatabase();
	}

	/**
    * 
    */
	@PUT
	public void reloadData() {
		reloadDatabase();
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
		User user = UserMapper.toDomainModel(userDto);
		user.setId(_idCounter.incrementAndGet());
		_userDB.put(user.getId(), user);

		_logger.debug("Created user: " + user);
		return Response.created(URI.create("/users/" + user.getId()))
				.build();
	}

	/**
	 * Updates an existing User. The parts of a User that can be updated are
	 * those represented by a UserDto instance.
	 * 
	 * @param dtoUser
	 *            - the User data included in the HTTP request body.
	 */
	@PUT
	@Path("{id}")
	@Consumes("application/xml")
	public void updateUser(UserDto userDto) {
		// Get the full User object from the database.
		User user = findUser(userDto.getId());

		// Update the User object in the database based on the data in
		// userDto.
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());

		// Ignore the last known location in UserDto (i.e. the data in the
		// HTTP request header).
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
	public void updateOrderHistory(@PathParam("id") long id, Order order) {
		// Get the full User object from the database.
		User user = findUser(id);

		// Update the user's order history.
		user.addOrderToHistory(order);
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
		User user = findUser(id);

		// Convert the full User a short User.
		UserDto userDto = UserMapper.toDto(user);

		return userDto;
	}

	/**
	 * Returns a view of the User database, represented as a List of UserDto
	 * objects.
	 */
	@GET
	@Produces("application/xml")
	public List<UserDto> getUsers() {
		List<UserDto> users = new ArrayList<UserDto>();

		for (Entry<Long, User> entry : _userDB.entrySet()) {
			users.add(UserMapper.toDto(entry.getValue()));
		}
		return users;
	}

	/**
	 * Returns order history for a particular User.
	 * 
	 * @param id
	 *            - the unique identifier of the User.
	 * 
	 */
	@GET
	@Path("{id}/orders")
	@Produces("application/xml")
	public List<Order> getOrderHistory(@PathParam("id") long id) {
		// Get the full User object from the database.
		User user = findUser(id);

		// Return the User's order history.
		return user.getOrderHistory();
	}

	protected User findUser(long id) {
		return _userDB.get(id);
	}

	protected void reloadDatabase() {
		_userDB = new ConcurrentHashMap<Long, User>();
		_idCounter = new AtomicLong();
		_idCounter.set(0);

		// === Initialise Parolee #1
		long id = _idCounter.incrementAndGet();
		User user = new User(id,
				"kxie",
				"1234",
				"Xie",
				"Karen");
		_userDB.put(id, user);

		// Make new order
		Order order = new Order();
		order.setTotalCost(1.11);
		order.setCustomerName("Karen Xie");
		order.setPaymentMethod(PaymentMethod.CREDIT_CARD);
		HashMap<Book, Integer> booksOrdered = new HashMap<>();
		Book book = new Book("Harry", "JK", "Fiction", 10.00, null);
		booksOrdered.put(book, 1);
		order.setBooksOrdered(booksOrdered);
		order.setDateOrdered();
		order.setShippingMethod(ShippingMethod.EXPRESS);

		user.addOrderToHistory(order);
	}
}
