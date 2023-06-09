package com.br.viniciusmaiacommerce.selltime.view.controller;

import com.br.viniciusmaiacommerce.selltime.dto.ProductDTO;
import com.br.viniciusmaiacommerce.selltime.service.ProductService;
import com.br.viniciusmaiacommerce.selltime.view.controller.model.ProductRequest;
import com.br.viniciusmaiacommerce.selltime.view.controller.model.ProductResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }
  @GetMapping
  public ResponseEntity<List<ProductResponse>> findAll() {
    List<ProductDTO> productDTOS = productService.findAll();

    ModelMapper mapper = new ModelMapper();

    List<ProductResponse> response = productDTOS.stream()
            .map(productDTO -> mapper.map(productDTO, ProductResponse.class))
            .collect(Collectors.toList());

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<ProductResponse>> findById(@PathVariable Integer id) {
   Optional<ProductDTO> dto = productService.findById(id);

   ProductResponse produto = new ModelMapper().map(dto.get(),ProductResponse.class);

   return new ResponseEntity<>(Optional.of(produto),HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
    ModelMapper mapper = new ModelMapper();

    ProductDTO productDTO = mapper.map(productRequest, ProductDTO.class);

    productDTO = productService.create(productDTO);

    return new ResponseEntity<>(mapper.map(productDTO, ProductResponse.class), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    productService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductResponse> update(@PathVariable Integer id, @RequestBody ProductRequest productRequest) {
    ModelMapper mapper = new ModelMapper();

    ProductDTO productDTO = mapper.map(productRequest, ProductDTO.class);

    productService.update(id, productDTO);

    return new ResponseEntity<>(
            mapper.map(productDTO, ProductResponse.class),
            HttpStatus.OK
    );

  }
}
