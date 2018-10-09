#!/bin/bash

#parse input parameters to comma separated list by $(echo $@ |tr ' ' ',')

java -jar target/bootLogisticSystem-0.0.1-SNAPSHOT.jar $@