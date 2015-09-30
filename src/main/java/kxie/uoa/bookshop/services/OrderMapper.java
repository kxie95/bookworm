package kxie.uoa.bookshop.services;

import kxie.uoa.bookshop.domain.Order;
import kxie.uoa.bookshop.dto.OrderDto;

public class OrderMapper {
	public static Order toDomainModel(OrderDto orderDto) {
		Order fullOrder = new Order(orderDto.getId(), orderDto.getTotalCost(), orderDto.getCustomerName(), orderDto.getDateOrdered(),
				orderDto.getShippingMethod(), orderDto.getPaymentMethod());
		return fullOrder;
	}

	public static OrderDto toDto(Order order) {
		OrderDto orderDto = new OrderDto(order.getId(), order.getTotalCost(), order.getDateOrdered(), order.getCustomerName(),
				order.getShippingMethod(), order.getPaymentMethod());
		return orderDto;

	}
}
