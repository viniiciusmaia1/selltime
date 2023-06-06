package com.br.viniciusmaiacommerce.selltime.repository;

import com.br.viniciusmaiacommerce.selltime.model.Product;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

//https://ifood.udemy.com/course/backend-completo-com-java-apirestfull-e-microsservicos/learn/lecture/28723660#overview
@Repository
public class ProductRepository {

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
         throw  new InputMismatchException("Produto nao encontrado.");
      }

      delete(product.getId());
      products.add(product);

      return product;
   }
}
