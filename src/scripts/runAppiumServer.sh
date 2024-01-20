#!/bin/bash
set -ex
sudo npm install -g appium --unsafe-perm=true --allow-root
appium -v
appium driver install uiautomator2
appium &>/dev/null &
