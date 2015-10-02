package kxie.uoa.bookshop.services.mappers;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import kxie.uoa.bookshop.domain.Order;
import kxie.uoa.bookshop.domain.OrderStatus;
import kxie.uoa.bookshop.domain.PaymentMethod;
import kxie.uoa.bookshop.domain.ShippingMethod;
import kxie.uoa.bookshop.domain.User;
import kxie.uoa.bookshop.dto.OrderDto;

/**
 * Class to convert between OrderDto and its domain model class Order.
 * @author Karen Xie kxie094
 *
 */
public class OrderMapper {
	
	public static Order toDomainModel(OrderDto orderDto) {	
		EntityManager em = Persistence.createEntityManagerFactory("bookShopPU").createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, orderDto.getOrderee());
		em.getTransaction().commit();
		
		Order fullOrder = new Order(
				user,
				orderDto.getTotalCost(),
				orderDto.getBooksOrdered(),
				orderDto.getDateOrdered(),
				PaymentMethod.fromString(orderDto.getPaymentMethod()),
				ShippingMethod.fromString(orderDto.getShippingMethod()),
				OrderStatus.fromString(orderDto.getOrderStatus())
				);

		return fullOrder;
	}

	public static OrderDto toDto(Order order) {
		OrderDto orderDto = new OrderDto(
				order.getId().longValue(),
				order.getOrderee().getId(),
				order.getTotalCost(),
				order.getBooksOrdered(),
				order.getDateOrdered(),
				order.getPaymentMethod().getMethod(),
				order.getShippingMethod().getMethod(),
				order.getOrderStatus().getStatus());
		return orderDto;

	}
}
