package kxie.uoa.bookshop.servlet;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import kxie.uoa.bookshop.domain.BookOrder;
import kxie.uoa.bookshop.dto.OrderDto;

public class Test {
	public static void main(String[] args) {
		try {
			AtomicLong orderId = new AtomicLong();
			orderId.set(0);
			HashSet<BookOrder> books = new HashSet<BookOrder>();
			books.add(new BookOrder("5678efgh", 5));
			OrderDto newOrder = new OrderDto(orderId.incrementAndGet(), 1.11, books, "Standard", "Bank_transfer");
			JAXBContext jaxbcontext = JAXBContext.newInstance(OrderDto.class);
			jaxbcontext.createMarshaller().marshal(newOrder, System.out);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
