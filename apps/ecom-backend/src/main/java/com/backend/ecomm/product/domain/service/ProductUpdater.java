package com.backend.ecomm.product.domain.service;


import com.backend.ecomm.order.domain.order.aggregate.OrderProductQuantity;
import com.backend.ecomm.product.domain.repository.ProductRepository;

import java.util.List;

public class ProductUpdater {

  private final ProductRepository productRepository;

  public ProductUpdater(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void updateProductQuantity(List<OrderProductQuantity> orderProductQuantities) {
    for (OrderProductQuantity orderProductQuantity : orderProductQuantities) {
      productRepository.updateQuantity(orderProductQuantity.productPublicId(),
        orderProductQuantity.quantity().value());
    }
  }
}
