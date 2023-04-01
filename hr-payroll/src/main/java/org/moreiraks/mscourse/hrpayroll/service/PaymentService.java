package org.moreiraks.mscourse.hrpayroll.service;

import org.moreiraks.mscourse.hrpayroll.entities.Payment;
import org.moreiraks.mscourse.hrpayroll.entities.Worker;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
  public Payment getPayment(Long workerId, Integer days){
    Worker worker = new Worker("Bob", 200.0);
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
  
}
