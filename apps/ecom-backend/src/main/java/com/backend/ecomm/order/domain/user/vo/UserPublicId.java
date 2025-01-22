package com.backend.ecomm.order.domain.user.vo;

import com.backend.ecomm.shared.error.domain.Assert;

import java.util.UUID;

public record UserPublicId(UUID value) {

  public UserPublicId {
    Assert.notNull("value", value);
  }
}
