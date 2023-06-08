package com.br.viniciusmaiacommerce.selltime.view.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {
  private String name;
  private Integer quantity;
  private double value;
  private String observation;
}
