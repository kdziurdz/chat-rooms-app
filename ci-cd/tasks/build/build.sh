#!/bin/bash -ex

cp -R app/* build/
cd build
mvn clean package

