package org.moreiraks.mscourse.hrpayroll.resources;

import org.moreiraks.mscourse.hrpayroll.entities.Payment;
import org.moreiraks.mscourse.hrpayroll.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResources {

  private final PaymentService paymentService;

  
  public PaymentResources(PaymentService paymentService) {
    this.paymentService = paymentService;
  }


  @GetMapping("/{workerId}/days/{days}")
  public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
    return ResponseEntity.ok(paymentService.getPayment(workerId, days));
  }
}
