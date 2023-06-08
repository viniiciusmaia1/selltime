package com.br.viniciusmaiacommerce.selltime.model;

import com.br.viniciusmaiacommerce.selltime.common.GenericEntity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product implements Serializable, GenericEntity {
  @Id
  @GeneratedValue(strategy = GenerationType. AUTO)
  @Column(nullable = false, updatable = false)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer quantity;

  @Column(nullable = false)
  private double value;

  @Column(columnDefinition = "text")
  private String observation;
}
