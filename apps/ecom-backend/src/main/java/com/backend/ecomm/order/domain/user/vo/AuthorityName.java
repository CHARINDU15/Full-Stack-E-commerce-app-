package com.backend.ecomm.order.domain.user.vo;

import com.backend.ecomm.shared.error.domain.Assert;

public record AuthorityName(String name) {

  public AuthorityName {
    Assert.field("name", name).notNull();
  }
}
