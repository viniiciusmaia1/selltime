package com.br.viniciusmaiacommerce.selltime.repository.product;

import com.br.viniciusmaiacommerce.selltime.model.Product;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public interface ProductRepository extends JpaRepository<Product, Integer> {}
