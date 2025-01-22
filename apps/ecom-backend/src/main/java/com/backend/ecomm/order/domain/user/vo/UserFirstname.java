package com.backend.ecomm.order.domain.user.vo;

import com.backend.ecomm.shared.error.domain.Assert;

public record UserFirstname(String value) {

  public UserFirstname {
    Assert.field("value", value).maxLength(255);
  }
}
