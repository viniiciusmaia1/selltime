package com.br.viniciusmaiacommerce.selltime.model.error;

import lombok.Getter;

@Getter
public class ErrorMessage {
  private String title;
  private Integer status;
  private String message;

  public ErrorMessage(String title, Integer status, String message) {
    this.title = title;
    this.status = status;
    this.message = message;
  }
  
}
