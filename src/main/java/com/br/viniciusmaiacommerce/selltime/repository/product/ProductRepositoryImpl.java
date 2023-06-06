package com.br.viniciusmaiacommerce.selltime.repository.product;

import com.br.viniciusmaiacommerce.selltime.model.Product;
import com.br.viniciusmaiacommerce.selltime.model.exception.ResourceNotFoundException;import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

   private ArrayList<Product> products = new ArrayList<Product>();
   private Integer lastId = 0;
   public List<Product> findAll() {
     return products;
   }

   public Optional<Product> findById(Integer productId) {
      return products
          .stream()
          .filter(products -> products.getId() == productId)
          .findFirst();
   }

   public Product create(Product product) {

      lastId++;
      product.setId(lastId);
      products.add(product);

      return product;
   }

   public void delete(Integer productId){
      products.removeIf(product -> product.getId() == productId);
   }

   public Product update(Product product) {
      var optionalProduct = findById(product.getId());

      if (optionalProduct.isEmpty()) {
         throw  new ResourceNotFoundException("Product not found.");
      }

      delete(product.getId());
      products.add(product);

      return product;
   }
}
