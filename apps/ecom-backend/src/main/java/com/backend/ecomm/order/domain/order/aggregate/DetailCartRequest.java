package com.backend.ecomm.order.domain.order.aggregate;

import org.jilt.Builder;

import java.util.List;

@Builder
public record DetailCartRequest(List<DetailCartItemRequest> items) {
}
