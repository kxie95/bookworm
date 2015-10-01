package kxie.uoa.bookshop.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import kxie.uoa.bookshop.services.resources.BookResourceImpl;
import kxie.uoa.bookshop.services.resources.ReviewResourceImpl;
import kxie.uoa.bookshop.services.resources.UserResource;

@ApplicationPath("/services")
public class BookShopApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public BookShopApplication() {
		// Register the UserResource singleton to handle HTTP requests.
		UserResource userResource = new UserResource();
		BookResourceImpl bookResource = new BookResourceImpl();
		ReviewResourceImpl reviewResource = new ReviewResourceImpl();
		singletons.add(userResource);
		singletons.add(bookResource);
		singletons.add(reviewResource);
		
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