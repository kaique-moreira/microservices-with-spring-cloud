package org.moreiraks.mscourse.hrpayroll.service;

import org.moreiraks.mscourse.hrpayroll.clients.WorkerClient;
import org.moreiraks.mscourse.hrpayroll.entities.Payment;
import org.moreiraks.mscourse.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
  
  private final WorkerClient workerClient;

  public PaymentService(WorkerClient workerClient) {
    this.workerClient = workerClient;
  }


  public Payment getPayment(Long workerId, Integer days){
    Worker worker = workerClient.findByID(workerId).getBody();
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
  
}
