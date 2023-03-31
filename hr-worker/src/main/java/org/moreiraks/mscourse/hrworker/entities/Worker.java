package org.moreiraks.mscourse.hrworker.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_worker")
@Entity
public class Worker implements Serializable{
  private static final long serialVersionUID=1l;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;
  private String name; 
  private Double dailyIncome;


  public Worker() {
  }
  

  public Worker(Long id, String name, Double dailyIncome) {
    this.id = id;
    this.name = name;
    this.dailyIncome = dailyIncome;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Double getDailyIncome() {
    return dailyIncome;
  }
  public void setDailyIncome(Double dailyIncome) {
    this.dailyIncome = dailyIncome;
  }


  
}
