package kxie.uoa.bookshop.services;

import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import kxie.uoa.bookshop.domain.Order;
import kxie.uoa.bookshop.domain.User;

public class BookShopResolver implements ContextResolver<JAXBContext> {
	private JAXBContext _context;

	public BookShopResolver() {
		try {
			// The JAXB Context should be able to marshal and unmarshal the
			// specified classes.
			_context = JAXBContext.newInstance(User.class, Order.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JAXBContext getContext(Class<?> type) {
		if (type.equals(User.class) || type.equals(Order.class)) {
			return _context;
		} else {
			return null;
		}
	}
}
