package com.backend.ecomm.order.domain.order.aggregate;

import com.backend.ecomm.order.domain.order.vo.StripeSessionId;
import com.backend.ecomm.order.domain.user.vo.UserAddressToUpdate;
import org.jilt.Builder;

import java.util.List;

@Builder
public record StripeSessionInformation(StripeSessionId stripeSessionId,
                                       UserAddressToUpdate userAddress,
                                       List<OrderProductQuantity> orderProductQuantity) {
}
