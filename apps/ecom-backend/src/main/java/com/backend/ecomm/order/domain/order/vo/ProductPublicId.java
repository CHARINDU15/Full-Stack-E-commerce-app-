package com.backend.ecomm.order.domain.order.vo;

import com.backend.ecomm.shared.error.domain.Assert;

import java.util.UUID;

public record ProductPublicId(UUID value) {

  public ProductPublicId {
    Assert.notNull("value", value);
  }
}
