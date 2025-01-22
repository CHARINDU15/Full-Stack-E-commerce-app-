package com.backend.ecomm.order.domain.user.vo;

import com.backend.ecomm.shared.error.domain.Assert;

public record UserLastname(String value) {

  public UserLastname {
    Assert.field("value", value).maxLength(255);
  }
}
