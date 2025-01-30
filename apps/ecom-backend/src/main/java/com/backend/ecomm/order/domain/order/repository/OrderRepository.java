package com.backend.ecomm.order.domain.order.repository;

import com.backend.ecomm.order.domain.order.aggregate.Order;
import com.backend.ecomm.order.domain.order.aggregate.StripeSessionInformation;
import com.backend.ecomm.order.domain.order.vo.OrderStatus;
import com.backend.ecomm.order.domain.user.vo.UserPublicId;
import com.backend.ecomm.product.domain.vo.PublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderRepository {

  void save(Order order);

  void updateStatusByPublicId(OrderStatus orderStatus, PublicId orderPublicId);

  Optional<Order> findByStripeSessionId(StripeSessionInformation stripeSessionInformation);

  Page<Order> findAllByUserPublicId(UserPublicId userPublicId, Pageable pageable);

  Page<Order> findAll(Pageable pageable);

}
