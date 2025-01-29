package com.backend.ecomm.product.domain.vo;

import com.backend.ecomm.shared.error.domain.Assert;

public record CategoryName(String value) {
  public CategoryName {
    Assert.field("value", value).notNull().minLength(3);
  }
}
