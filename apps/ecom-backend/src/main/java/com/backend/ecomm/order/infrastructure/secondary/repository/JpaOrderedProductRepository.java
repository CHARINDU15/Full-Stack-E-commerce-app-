package com.backend.ecomm.order.infrastructure.secondary.repository;

import com.backend.ecomm.order.infrastructure.secondary.entity.OrderedProductEntity;
import com.backend.ecomm.order.infrastructure.secondary.entity.OrderedProductEntityPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderedProductRepository extends JpaRepository<OrderedProductEntity, OrderedProductEntityPk> {

}
