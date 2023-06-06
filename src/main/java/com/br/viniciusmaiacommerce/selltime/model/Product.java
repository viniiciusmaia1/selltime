package com.br.viniciusmaiacommerce.selltime.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
  private Integer id;
  private String name;
  private Integer quantity;
  private double value;
  private String observation;

}
