package com.backend.ecomm.order.domain.order.aggregate;

import com.backend.ecomm.order.domain.order.vo.OrderQuantity;
import com.backend.ecomm.order.domain.order.vo.ProductPublicId;
import org.jilt.Builder;

@Builder
public record OrderProductQuantity(OrderQuantity quantity, ProductPublicId productPublicId) {
}
