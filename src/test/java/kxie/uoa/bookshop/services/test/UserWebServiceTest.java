package kxie.uoa.bookshop.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import kxie.uoa.bookshop.dto.BookDto;
import kxie.uoa.bookshop.dto.UserDto;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserWebServiceTest {
	private Logger _logger = LoggerFactory.getLogger(UserWebServiceTest.class);

	private static final String WEB_SERVICE_URI_USERS = "http://localhost:8080/services/users";
	private static final String WEB_SERVICE_URI_BOOKS = "http://localhost:8080/services/books";

	private static Client _client;

	/**
	 * One-time setup method that creates a Web service client.
	 */
	@BeforeClass
	public static void setUp() {
		_client = ClientBuilder.newClient();
	}

	/**
	 * Runs before each unit test restore Web service database. This ensures
	 * that each test is independent.
	 */
	@Before
	public void reloadServerData() {
		Response responseUsers = _client.target(WEB_SERVICE_URI_USERS).request().put(null);
		responseUsers.close();
		
		Response responseBooks = _client.target(WEB_SERVICE_URI_BOOKS).request().put(null);
		responseBooks.close();

		// Pause briefly before running any tests. Test addParoleeMovement(),
		// for example, involves creating a timestamped value (a movement) and
		// having the Web service compare it with data just generated with
		// timestamps. Joda's Datetime class has only millisecond precision,
		// so pause so that test-generated timestamps are actually later than
		// timestamped values held by the Web service.
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * One-time finalisation method that destroys the Web service client.
	 */
	@AfterClass
	public static void destroyClient() {
		_client.close();
	}

	/**
	 * Tests that the Web service can create a new User.
	 */
	@Test
	public void addUserTest() {
		UserDto karen = new UserDto("hello", "1234", "Hello", "World");

		Response response = _client.target(WEB_SERVICE_URI_USERS).request().post(Entity.xml(karen));
		if (response.getStatus() != 201) {
			_logger.error("Failed to new User; Web service responded with: " + response.getStatus());
			fail("Failed to create new User");
		}

		String location = response.getLocation().toString();
		response.close();

		// Query the Web service for the new User
		UserDto karenFromService = _client.target(location).request().accept("application/xml").get(UserDto.class);

		assertEquals(karen.getLastname(), karenFromService.getLastname());
		assertEquals(karen.getFirstname(), karenFromService.getFirstname());
		assertEquals(karen.getUsername(), karenFromService.getUsername());
		assertEquals(karen.getPassword(), karenFromService.getPassword());
	}
	
	/**
	 * Tests that the Web service can create a new Book.
	 */
	@Test
	public void addBookTest() {
		BookDto bookDto = new BookDto("Harry Potter", "JK Rowling", "Novel", 20.00);

		Response response = _client.target(WEB_SERVICE_URI_BOOKS).request().post(Entity.xml(bookDto));
		
		if (response.getStatus() != 201) {
			_logger.error("Failed to create new Book; Web service responded with: " + response.getStatus());
			fail("Failed to create new Book");
		}

		String location = response.getLocation().toString();
		response.close();

		// Query the Web service for the new User
		BookDto bookFromService = _client.target(location).request().accept("application/xml").get(BookDto.class);

		assertEquals(bookDto.getTitle(), bookFromService.getTitle());
		assertEquals(bookDto.getAuthor(), bookFromService.getAuthor());
		assertEquals(bookDto.getGenre(), bookFromService.getGenre());
		assertEquals(bookDto.getPrice(), bookFromService.getPrice(), 0.01);
	}

//	/**
//	 * Tests that the Web service can process requests to record new User order.
//	 */
//	@Test
//	public void addReview() {
//
//		// Make new order
//		ReviewDto newReview = new ReviewDto();
//
//		Response response = _client.target(WEB_SERVICE_URI + "/1/orders").request().put(Entity.xml(newOrder));
//		if (response.getStatus() != 204) {
//			_logger.error("Failed to new order; Web service responded with: " + response.getStatus());
//			fail("Failed to create new order");
//		}
//		response.close();
//
//		// Query the Web service for the User whose order history has been
//		// updated.
//		UserDto karen = _client.target(WEB_SERVICE_URI + "/1").request().accept("application/xml").get(UserDto.class);
//		Order mostRecentOrder = karen.getMostRecentOrder();
//		assertEquals(newOrder.getCustomerName(), mostRecentOrder.getCustomerName());
//		assertEquals(newOrder.getOrderStatus(), mostRecentOrder.getOrderStatus());
//		assertEquals(newOrder.getPaymentMethod(), mostRecentOrder.getPaymentMethod());
//		assertEquals(newOrder.getShippingMethod(), mostRecentOrder.getShippingMethod());
//		assertEquals(newOrder.getTotalCost(), mostRecentOrder.getTotalCost(), 0.01);
//
//	}

}
