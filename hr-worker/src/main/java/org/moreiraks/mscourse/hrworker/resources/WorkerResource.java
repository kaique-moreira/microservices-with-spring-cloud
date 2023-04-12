package org.moreiraks.mscourse.hrworker.resources;

import java.util.List;

import org.moreiraks.mscourse.hrworker.entities.Worker;
import org.moreiraks.mscourse.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
  
  private final WorkerRepository repository;
  @Value("${test.config}")
	private String testConfig;


  private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
  
  

  public WorkerResource(WorkerRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public ResponseEntity<Worker> save(@RequestBody Worker worker){
    return ResponseEntity.ok(repository.save(worker));
  }

  @GetMapping
  public ResponseEntity<List<Worker>> findAll(){
    return ResponseEntity.ok(repository.findAll());
  }

  @GetMapping("/configs")
  public ResponseEntity<Void> config(){
    logger.info("config:" + testConfig);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Worker> findByID(@PathVariable Long id){
    return ResponseEntity.ok(repository.findById(id).get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteByID(@PathVariable Long id){
    Worker toDelete = repository.findById(id).orElseThrow( () ->  new RuntimeException());
    repository.delete(toDelete);
    return ResponseEntity.noContent().build();
  }

}
