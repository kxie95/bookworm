package kxie.uoa.bookshop.services;

import kxie.uoa.bookshop.domain.Order;
import kxie.uoa.bookshop.domain.Order.PaymentMethod;
import kxie.uoa.bookshop.domain.Order.ShippingMethod;
import kxie.uoa.bookshop.dto.OrderDto;

public class OrderMapper {
	static Order toDomainModel(OrderDto orderDto) {
		Order fullOrder = new Order(orderDto.getId(), orderDto.getTotalCost(), orderDto.getBooksOrdered(), orderDto.getDateOrdered(),
				ShippingMethod.fromString(orderDto.getShippingMethod()), PaymentMethod.fromString(orderDto.getPaymentMethod()));
		return fullOrder;
	}

	static OrderDto toDto(Order order) {
		OrderDto orderDto = new OrderDto(order.getId(), order.getTotalCost(), order.getBooksOrdered(),
				order.getShippingMethod().toString(), order.getPaymentMethod().toString());
		return orderDto;

	}
}
