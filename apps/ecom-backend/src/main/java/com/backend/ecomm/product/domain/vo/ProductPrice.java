package com.backend.ecomm.product.domain.vo;

import com.backend.ecomm.shared.error.domain.Assert;

public record ProductPrice(double value) {

  public ProductPrice {
    Assert.field("value", value).min(0.1);
  }
}
