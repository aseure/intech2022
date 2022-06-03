#!/usr/bin/env bash

set -e

if [ -z "${USER}" ]; then exit 1; fi

mvn clean package
scp -i upload target/intech-1.0-SNAPSHOT.jar student@51.15.239.63:~/jars/${USER}.jar
