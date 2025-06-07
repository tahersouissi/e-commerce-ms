package com.naim.ecommerce.payment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

  private final PaymentService service;
  public  PaymentController (PaymentService service){
    this.service = service;
  }

  @PostMapping
  @CrossOrigin(origins = "*")
  public ResponseEntity<Integer> createPayment(
      @RequestBody  PaymentRequest request
  ) {
    return ResponseEntity.ok(this.service.createPayment(request));
  }
}
