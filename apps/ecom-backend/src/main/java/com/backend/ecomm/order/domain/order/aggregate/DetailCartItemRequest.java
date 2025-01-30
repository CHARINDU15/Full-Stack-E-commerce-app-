package com.backend.ecomm.order.domain.order.aggregate;

import com.backend.ecomm.product.domain.vo.PublicId;
import org.jilt.Builder;

@Builder
public record DetailCartItemRequest(PublicId productId, long quantity) {
}
