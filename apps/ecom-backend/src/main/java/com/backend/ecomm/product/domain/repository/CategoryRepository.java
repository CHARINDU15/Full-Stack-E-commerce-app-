package com.backend.ecomm.product.domain.repository;

import com.backend.ecomm.product.domain.aggregate.Category;
import com.backend.ecomm.product.domain.vo.PublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryRepository {

  Page<Category> findAll(Pageable pageable);

  int delete(PublicId publicId);

  Category save(Category categoryToCreate);

}
