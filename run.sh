#!/bin/bash

#parse input parameters to comma separated list by $(echo $@ |tr ' ' ',')

./mvnw spring-boot:run -Dspring-boot.run.arguments=$(echo $@ |tr ' ' ',')