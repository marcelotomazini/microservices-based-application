#!/bin/bash
mvn clean install
docker-compose build --build-arg VERSION="0.1.0" 
docker-compose up