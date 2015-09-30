package kxie.uoa.bookshop.services;

import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import kxie.uoa.bookshop.domain.Order;
import kxie.uoa.bookshop.dto.UserDto;

public class Test {
	public static void main(String[] args) {
		try {
			AtomicLong orderId = new AtomicLong();
			orderId.set(0);

			UserDto user = new UserDto(orderId.incrementAndGet(), "kxie", "1234", "Xie", "Karen", new Order());
			JAXBContext jaxbcontext = JAXBContext.newInstance(UserDto.class);
			Marshaller marshal = jaxbcontext.createMarshaller();
			marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshal.marshal(user, System.out);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
