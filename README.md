# Test Automation Project with Appium

## Overview

This project is a test automation framework built with Appium for mobile application testing. It aims to provide a scalable and maintainable architecture for automating Android apps. iOS support is currently not available.

## Features


- **Page Object Model (POM):** Utilizes the Page Object Model design pattern for improved readability and maintainability.
- **TestNG integration:** Uses TestNG for test execution, and reporting.
- **Logging:** Incorporates logging to provide detailed information about test execution.
- **CI/CD Integration:** Ability to integrate with app's CI/CD pipelines using github actions. Tests will be run on virtual android devices.
- **Screenshot capture:** Captures screenshots on test failure for better debugging.

## Prerequisites

Make sure you have the following software installed.

- Java Development Kit (JDK)
- Appium server
- Android Studio with emulator and other platform tools
- avd created with required api

## Getting Started

1. **Clone the repository**

   ```bash
   git clone git@github.com:sonu-puthuk/appium-tests.git
   
2. **Install dependencies**

    ```bash
    ./gradlew clean build

3. **Start Appium Server**
    ```bash
    appium
   
4. **Start Emulator**
      ```bash
    emulator -avd <name>
   
4. **Run tests**

    ```bash
    ./gradlew test
