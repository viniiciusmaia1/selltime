package com.br.viniciusmaiacommerce.selltime.controller;

import com.br.viniciusmaiacommerce.selltime.model.Product;import com.br.viniciusmaiacommerce.selltime.service.ProductService;
import java.util.List;import java.util.Optional;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<Product> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Product> findById(@PathVariable Integer id) {
    return productService.findById(id);
  }

  @PostMapping
  public Product create(@RequestBody Product product) {
    return productService.create(product);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
     productService.delete(id);
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable Integer id, @RequestBody Product product) {
    productService.update(id,product);
    return product;
  }

}
