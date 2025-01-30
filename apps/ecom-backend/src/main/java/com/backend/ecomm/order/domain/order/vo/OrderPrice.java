package com.backend.ecomm.order.domain.order.vo;

import com.backend.ecomm.shared.error.domain.Assert;

public record OrderPrice(double value) {

  public OrderPrice {
    Assert.field("value", value).strictlyPositive();
  }
}
