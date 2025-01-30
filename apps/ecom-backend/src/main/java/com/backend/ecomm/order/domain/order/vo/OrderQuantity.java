package com.backend.ecomm.order.domain.order.vo;

import com.backend.ecomm.shared.error.domain.Assert;

public record OrderQuantity(long value) {

  public OrderQuantity {
    Assert.field("value", value).positive();

  }
}
