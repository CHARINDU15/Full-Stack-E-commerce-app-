package com.backend.ecomm.order.domain.user.aggregate;

import com.backend.ecomm.order.domain.user.vo.AuthorityName;
import com.backend.ecomm.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public class Authority {

  private AuthorityName name;

  public Authority(AuthorityName authorityName) {
    Assert.notNull("name", authorityName);
    this.name = authorityName;
  }

  public AuthorityName getName() {
    return name;
  }
}
