package com.backend.ecomm.product.domain.vo;

import com.backend.ecomm.shared.error.domain.Assert;

public record ProductBrand(String value) {

  public ProductBrand {
    Assert.field("value", value).notNull().minLength(3);
  }
}
