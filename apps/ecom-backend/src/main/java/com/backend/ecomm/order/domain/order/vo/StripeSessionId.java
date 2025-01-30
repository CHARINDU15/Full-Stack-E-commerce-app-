package com.backend.ecomm.order.domain.order.vo;


import com.backend.ecomm.shared.error.domain.Assert;

public record StripeSessionId(String value) {

  public StripeSessionId {
    Assert.notNull("value", value);
  }
}
