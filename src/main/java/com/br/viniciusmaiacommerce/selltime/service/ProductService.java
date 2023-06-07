package com.br.viniciusmaiacommerce.selltime.service;

import com.br.viniciusmaiacommerce.selltime.model.Product;
import com.br.viniciusmaiacommerce.selltime.repository.product.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired private ProductRepository productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Optional<Product> findById(Integer productId) {
    return productRepository.findById(productId);
  }

  public Product create(Product product) {
    return productRepository.save(product);
  }

  public void delete(Product product) {
    productRepository.delete(product);
  }

  public Product update(Integer productId, Product product) {
    return productRepository.save(product);
  }
}
