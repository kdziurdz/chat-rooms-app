#!/bin/bash -ex

cp -R app/* build/
cd build
npm clean package

