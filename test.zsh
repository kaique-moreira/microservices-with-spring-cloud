#!/bin/zsh
pids=( )

# define cleanup function
cleanup() {
  for pid in "${pids[@]}"; do
    kill -0 "$pid" && kill "$pid" # kill process only if it's still running
  done
}

# and set that function to run before we exit, or specifically when we get a SIGTERM
trap cleanup EXIT TERM 

cd ./hr-eureka-server 
 mvn spring-boot:run &
 sleep 5 &&
cd ../hr-config-server 
 mvn spring-boot:run & pids+=( "$!" )
 sleep 5 

wait

