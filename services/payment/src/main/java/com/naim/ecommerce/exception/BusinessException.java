package com.naim.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

  private final String msg;
  public  BusinessException(String msg){
    this.msg = msg;
  }
}
