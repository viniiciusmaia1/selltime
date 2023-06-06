package com.br.viniciusmaiacommerce.selltime.model;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
  private Integer id;
  private String name;
  private Integer quantidade;
  private double value;
  private String observacao;

}
