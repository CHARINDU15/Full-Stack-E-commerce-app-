package com.backend.ecomm.product.domain.vo;

import com.backend.ecomm.shared.error.domain.Assert;

import java.util.UUID;

public record PublicId(UUID value) {

  public PublicId {
    Assert.notNull("value", value);
  }
}
