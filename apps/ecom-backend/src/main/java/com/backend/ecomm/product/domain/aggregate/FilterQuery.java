package com.backend.ecomm.product.domain.aggregate;

import com.backend.ecomm.product.domain.vo.ProductSize;
import com.backend.ecomm.product.domain.vo.PublicId;
import org.jilt.Builder;

import java.util.List;

@Builder
public record FilterQuery(PublicId categoryId, List<ProductSize> sizes) {
}
