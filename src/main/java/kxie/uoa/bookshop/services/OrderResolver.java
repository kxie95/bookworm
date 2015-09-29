package kxie.uoa.bookshop.services;

import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import kxie.uoa.bookshop.domain.Order;

public class OrderResolver implements ContextResolver<JAXBContext> {
	private JAXBContext _context;

	public OrderResolver() {
		try {
			_context = JAXBContext.newInstance(Order.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JAXBContext getContext(Class<?> type) {
		if (type.equals(Order.class)) {
			return _context;
		} else {
			return null;
		}
	}
}
