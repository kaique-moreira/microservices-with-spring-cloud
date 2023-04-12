#!/bin/zsh

cd ./hr-eureka-server 
 mvn spring-boot:run &
 sleep 5 &&
cd ../hr-worker/ 
 mvn spring-boot:run

