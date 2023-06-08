package com.br.viniciusmaiacommerce.selltime.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
  private Integer id;
  private String name;
  private Integer quantity;
  private double value;
  private String observation;
}
