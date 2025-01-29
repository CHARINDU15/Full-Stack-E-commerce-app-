package com.backend.ecomm.product.infrastructure.secondary.repository;

import com.backend.ecomm.product.infrastructure.secondary.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductPictureRepository extends JpaRepository<PictureEntity, Long> {
}
