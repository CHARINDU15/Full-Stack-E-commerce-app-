package com.backend.ecomm.product.application;
import com.backend.ecomm.order.domain.order.aggregate.OrderProductQuantity;
import com.backend.ecomm.product.domain.aggregate.Category;
import com.backend.ecomm.product.domain.aggregate.FilterQuery;
import com.backend.ecomm.product.domain.aggregate.Product;
import com.backend.ecomm.product.domain.repository.CategoryRepository;
import com.backend.ecomm.product.domain.repository.ProductRepository;
import com.backend.ecomm.product.domain.service.CategoryCRUD;
import com.backend.ecomm.product.domain.service.ProductCRUD;
import com.backend.ecomm.product.domain.service.ProductShop;
import com.backend.ecomm.product.domain.service.ProductUpdater;
import com.backend.ecomm.product.domain.vo.PublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsApplicationService {

  private ProductCRUD productCRUD;
  private CategoryCRUD categoryCRUD;
  private ProductShop productShop;
  private ProductUpdater productUpdater;

  public ProductsApplicationService(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productCRUD = new ProductCRUD(productRepository);
    this.categoryCRUD = new CategoryCRUD(categoryRepository);
    this.productShop = new ProductShop(productRepository);
    this.productUpdater = new ProductUpdater(productRepository);
  }

  @Transactional
  public Product createProduct(Product newProduct) {
    return productCRUD.save(newProduct);
  }

  @Transactional(readOnly = true)
  public Page<Product> findAllProduct(Pageable pageable) {
    return productCRUD.findAll(pageable);
  }

  @Transactional
  public PublicId deleteProduct(PublicId publicId) {
    return productCRUD.delete(publicId);
  }

  @Transactional
  public Category createCategory(Category category) {
    return categoryCRUD.save(category);
  }

  @Transactional
  public PublicId deleteCategory(PublicId publicId) {
    return categoryCRUD.delete(publicId);
  }

  @Transactional(readOnly = true)
  public Page<Category> findAllCategory(Pageable pageable) {
    return categoryCRUD.findAll(pageable);
  }

  @Transactional(readOnly = true)
  public Page<Product> getFeaturedProducts(Pageable pageable) {
    return productShop.getFeaturedProducts(pageable);
  }

  @Transactional(readOnly = true)
  public Optional<Product> findOne(PublicId id) {
    return productCRUD.findOne(id);
  }

  @Transactional(readOnly = true)
  public Page<Product> findRelated(Pageable pageable, PublicId productPublicId) {
    return productShop.findRelated(pageable, productPublicId);
  }

  @Transactional(readOnly = true)
  public Page<Product> filter(Pageable pageable, FilterQuery query) {
    return productShop.filter(pageable, query);
  }

  @Transactional(readOnly = true)
  public List<Product> getProductsByPublicIdsIn(List<PublicId> publicIds) {
    return productCRUD.findAllByPublicIdIn(publicIds);
  }

  @Transactional
  public void updateProductQuantity(List<OrderProductQuantity> orderProductQuantities) {
    productUpdater.updateProductQuantity(orderProductQuantities);
  }

}
