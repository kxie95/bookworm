package kxie.uoa.bookshop.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import kxie.uoa.bookshop.domain.Order;
import kxie.uoa.bookshop.dto.OrderDto;
import kxie.uoa.bookshop.dto.UserDto;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserWebServiceTest {
	private Logger _logger = LoggerFactory.getLogger(UserWebServiceTest.class);

	private static final String WEB_SERVICE_URI = "http://localhost:8080/services/users";

	private static Client _client;
	private static EntityManager _entityManager;

	/**
	 * One-time setup method that creates a Web service client.
	 */
	@BeforeClass
	public static void setUp() {
		_client = ClientBuilder.newClient();
	}

	/**
	 * Runs before each unit test restore Web service database. This ensures
	 * that each test is independent; each test runs on a Web service that has
	 * been initialised with a common set of Parolees.
	 */
	@Before
	public void reloadServerData() {
		Response response = _client.target(WEB_SERVICE_URI).request().put(null);
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

		Response response = _client.target(WEB_SERVICE_URI).request().post(Entity.xml(karen));
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
	 * Tests that the Web service can process requests to record new User order.
	 */
	@Test
	public void addToOrderHistory() {

		AtomicLong orderId = new AtomicLong();
		orderId.set(0);
		// Make new order
		OrderDto newOrder = new OrderDto(orderId.incrementAndGet(), 10.11, new Date().toString(), "Karen Xie", "Standard", "Bank_transfer");

		Response response = _client.target(WEB_SERVICE_URI + "/1/orders").request().put(Entity.xml(newOrder));
		if (response.getStatus() != 204) {
			_logger.error("Failed to new order; Web service responded with: " + response.getStatus());
			fail("Failed to create new order");
		}
		response.close();

		// Query the Web service for the User whose order history has been
		// updated.
		UserDto karen = _client.target(WEB_SERVICE_URI + "/1").request().accept("application/xml").get(UserDto.class);
		Order mostRecentOrder = karen.getMostRecentOrder();
		assertEquals(newOrder.getCustomerName(), mostRecentOrder.getCustomerName());
		assertEquals(newOrder.getOrderStatus(), mostRecentOrder.getOrderStatus());
		assertEquals(newOrder.getPaymentMethod(), mostRecentOrder.getPaymentMethod());
		assertEquals(newOrder.getShippingMethod(), mostRecentOrder.getShippingMethod());
		assertEquals(newOrder.getTotalCost(), mostRecentOrder.getTotalCost(), 0.01);

	}

	/**
	 * Helper method to print out generated XML by JAXB.
	 */
	public void printXml(Object object) {
		JAXBContext jaxbcontext;
		try {
			jaxbcontext = JAXBContext.newInstance(object.getClass());
			Marshaller marshal = jaxbcontext.createMarshaller();
			marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshal.marshal(object, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
