package com.br.viniciusmaiacommerce.selltime.repository.product;

import com.br.viniciusmaiacommerce.selltime.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  public List<Product> findAll();

  public Optional<Product> findById(Integer productId);

  public Product create(Product product);

  public void delete(Integer productId);

  public Product update(Product product);
}
