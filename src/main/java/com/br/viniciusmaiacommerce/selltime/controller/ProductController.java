package com.br.viniciusmaiacommerce.selltime.controller;

import com.br.viniciusmaiacommerce.selltime.model.Product;import com.br.viniciusmaiacommerce.selltime.service.ProductService;
import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping
  public List<Product> findById() {
    return productService.findAll();
  }

}
