package kxie.uoa.bookshop.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class BookShopApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public BookShopApplication() {
		// Register the UserResource singleton to handle HTTP requests.
		UserResource resource = new UserResource();
		BookResourceImpl bookResource = new BookResourceImpl();
		singletons.add(resource);
		singletons.add(bookResource);
		// Register the ContextResolver class for JAXB.
		classes.add(BookShopResolver.class);

	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}