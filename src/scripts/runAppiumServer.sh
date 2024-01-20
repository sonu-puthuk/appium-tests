#!/bin/bash
set -ex
sudo npm install -g appium
appium -v
appium driver install uiautomator2
appium &>/dev/null &
