package com.backend.ecomm.order.domain.user.vo;

import com.backend.ecomm.shared.error.domain.Assert;

public record UserImageUrl(String value) {

  public UserImageUrl {
    Assert.field("value", value).maxLength(1000);
  }
}
