package org.moreiraks.mscourse.hrpayroll.service;

import org.moreiraks.mscourse.hrpayroll.entities.Payment;
import org.moreiraks.mscourse.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {
  
  @Value("${hr-worker.host}")
  private  String host;
  private final RestTemplate restTemplate;

  public PaymentService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }



  public Payment getPayment(Long workerId, Integer days){
    Worker worker = restTemplate.getForObject(host.concat("/workers/" + workerId), Worker.class);
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
  
}
