package kxie.uoa.bookshop.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import kxie.uoa.bookshop.domain.Book;
import kxie.uoa.bookshop.domain.Order;
import kxie.uoa.bookshop.domain.Order.PaymentMethod;
import kxie.uoa.bookshop.domain.Order.ShippingMethod;
import kxie.uoa.bookshop.dto.UserDto;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserWebServiceTest {
	private static final String WEB_SERVICE_URI = "http://localhost:8080/services/users";

	private static Client _client;

	/**
	 * One-time setup method that creates a Web service client.
	 */
	@BeforeClass
	public static void setUpClient() {
		_client = ClientBuilder.newClient();
	}

	/**
	 * Runs before each unit test restore Web service database. This ensures
	 * that each test is independent; each test runs on a Web service that has
	 * been initialised with a common set of Parolees.
	 */
	@Before
	public void reloadServerData() {
		Response response = _client
				.target(WEB_SERVICE_URI).request()
				.put(null);
		response.close();

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
	public void addUser() {
		UserDto karen = new UserDto("kxie", "1234", "Xie", "Karen");

		Response response = _client
				.target(WEB_SERVICE_URI).request()
				.post(Entity.xml(karen));
		if (response.getStatus() != 201) {
			fail("Failed to create new User");
		}

		String location = response.getLocation().toString();
		response.close();

		// Query the Web service for the new User
		UserDto karenFromService = _client.target(location).request()
				.accept("application/xml").get(UserDto.class);

		// The original local User object (karen) should have a value equal
		// to that of the User object representing Karen that is later
		// queried from the Web service. The only exception is the value
		// returned by getId(), because the Web service assigns this when it
		// creates a User.
		assertEquals(karen.getLastname(), karenFromService.getLastname());
		assertEquals(karen.getFirstname(), karenFromService.getFirstname());
		assertEquals(karen.getUsername(), karenFromService.getUsername());
		assertEquals(karen.getPassword(), karenFromService.getPassword());
	}

	/**
	 * Tests that the Web serves can process requests to record new Parolee
	 * movements.
	 */
	@Test
	public void addToOrderHistory() {

		// Make new order
		HashMap<Book, Integer> books = new HashMap<>();
		books.put(new Book("Ron Weasley", "JK Rowling", "Fiction", 12.00, null), 1);
		Order newOrder = new Order(1.11,
				books, new Date(),
				ShippingMethod.STANDARD,
				PaymentMethod.BANK_TRANSFER);

		Response response = _client
				.target(WEB_SERVICE_URI + "/1/orders")
				.request().post(Entity.xml(newOrder));
		if (response.getStatus() != 204) {
			fail("Failed to create new Movement");
		}
		response.close();

		// Query the Web service for the Parolee whose location has been
		// updated.
		UserDto karen = _client
				.target(WEB_SERVICE_URI + "/1").request()
				.accept("application/xml").get(UserDto.class);
		assertEquals(newOrder, karen.getMostRecentOrder());
	}

}
