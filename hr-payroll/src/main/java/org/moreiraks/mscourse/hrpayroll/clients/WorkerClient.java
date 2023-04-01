package org.moreiraks.mscourse.hrpayroll.clients;

import java.util.List;

import org.moreiraks.mscourse.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8081", path = "/workers")
public interface WorkerClient {
  
  @PostMapping
  ResponseEntity<Worker> save(@RequestBody Worker worker);

  @GetMapping
  ResponseEntity<List<Worker>> findAll();

  @GetMapping("/{id}")
  ResponseEntity<Worker> findByID(@PathVariable Long id);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteByID(@PathVariable Long id);
}
