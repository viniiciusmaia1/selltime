package com.br.viniciusmaiacommerce.selltime.service;

import com.br.viniciusmaiacommerce.selltime.model.Product;import com.br.viniciusmaiacommerce.selltime.repository.product.ProductRepositoryImpl;
import java.util.List;import java.util.Optional;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepositoryImpl productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Optional<Product> findById (Integer productId) {
    return productRepository.findById(productId);
  }

  public Product create(Product product) {
    return productRepository.create(product);
  }

  public void delete(Integer productId) {
    productRepository.delete(productId);
  }

  public Product update(Integer productId, Product product) {

    product.setId(productId);

    return productRepository.update(product);

  }

}
