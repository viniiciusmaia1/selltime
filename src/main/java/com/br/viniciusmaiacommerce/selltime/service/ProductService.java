package com.br.viniciusmaiacommerce.selltime.service;

import com.br.viniciusmaiacommerce.selltime.dto.ProductDTO;
import com.br.viniciusmaiacommerce.selltime.model.Product;
import com.br.viniciusmaiacommerce.selltime.model.exception.ResourceNotFoundException;
import com.br.viniciusmaiacommerce.selltime.repository.product.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired private ProductRepository productRepository;

  public List<ProductDTO> findAll() {

    // Model
    List<Product> products = productRepository.findAll();

    // Convert to ProductDTO
    return products.stream()
        .map(product -> new ModelMapper().map(product, ProductDTO.class))
        .collect(Collectors.toList());
  }

  public Optional<ProductDTO> findById(Integer productId) {
    Optional<Product> product = productRepository.findById(productId);

    if (product.isEmpty()) {
      throw new ResourceNotFoundException("Product with id: " + productId + " not found.");
    }

    ProductDTO productDTO = new ModelMapper().map(product.get(), ProductDTO.class);

    return Optional.of(productDTO);
  }

  public ProductDTO create(ProductDTO productDTO) {
    productDTO.setId(null);

    ModelMapper mapper = new ModelMapper();

    Product product = mapper.map(productDTO, Product.class);

    productRepository.save(product);

    productDTO.setId(product.getId());

    return productDTO;
  }

  public void delete(Integer productId) {
    Optional<Product> product = productRepository.findById(productId);

    if(product.isEmpty()) {
      throw new ResourceNotFoundException("Product with id: " + productId + " not found.");
    }

    

  }

  public ProductDTO update(Integer productId, ProductDTO product) {

    product.setId(productId);

    return productRepository.save(product);
  }
}
