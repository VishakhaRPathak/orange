# orange
Testing of OrangeHRM website

# OrangeHRM Selenium Automation Framework

A basic UI automation framework for the OrangeHRM demo application built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**.

## Project Overview

This project demonstrates a maintainable Selenium automation framework following Page Object Model (POM) principles. The framework is designed to be scalable and serves as a foundation for building enterprise-level automation frameworks.

Current implementation includes:

- Selenium WebDriver
- Java
- TestNG
- Maven
- Page Object Model (POM)
- Reusable UI Components
- Explicit Wait Utilities
- Configurable test execution
- Extent Reports
- Screenshot capture on failure (planned/improving)

---

## Technology Stack

| Technology | Version |
|------------|---------|
| Java | 17+ |
| Selenium WebDriver | Latest |
| TestNG | Latest |
| Maven | Latest |
| Extent Reports | Latest |

---

## Project Structure

```
src
├── main
│   ├── java
│   │   ├── components
│   │   ├── pages
│   │   ├── models
│   │   ├── utility
│   │   ├── driver
│   │   └── configuration
│   └── resources
│
└── test
    ├── java
    │   └── tests
    └── resources
```

---

## Framework Features

### Page Object Model

Each page contains only business operations and page-specific elements.

Example:

- Login Page
- Dashboard Page
- Leave List Page

---

### Reusable Components

Reusable UI components reduce duplication and improve maintainability.

Examples:

- Custom Dropdown
- Multi Select Dropdown
- Date Picker
- Auto Complete
- CheckBox
- Results Table

---

### Utility Classes

Framework utilities include:

- DriverManager
- WaitUtils
- ConfigReader
- ReportUtils
- ScreenshotUtils
- RetryAnalyzer (planned)
- ExcelUtils (planned)

---

## Configuration

All configurable values are stored in:

```
config.properties
```

Example:

```properties
browser=chrome
url=https://opensource-demo.orangehrmlive.com
username=Admin
password=admin123
waitTime=10
```

---

## Running Tests

Run all tests using Maven:

```bash
mvn clean test
```

Or execute a specific TestNG suite:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## Design Principles

This framework follows:

- Page Object Model
- Component-based architecture
- Single Responsibility Principle
- Encapsulation
- Reusable business methods
- Explicit waits over Thread.sleep()
- Maintainable locator strategy

---

## Current Components

- Login
- Date Picker
- Custom Dropdown
- Multi Select Dropdown
- Employee Auto Complete
- CheckBox
- Leave Search Criteria Model

---

## Future Improvements

- Parallel execution
- ThreadLocal DriverManager
- Thread-safe Extent Reports
- Retry Analyzer
- Screenshot attachment to reports
- Jenkins integration
- GitHub Actions CI/CD
- Docker execution
- Cross-browser support
- Excel data provider
- API integration
- Database validation

---

## Demo Application

OrangeHRM Open Source Demo

https://opensource-demo.orangehrmlive.com/

---

## Author

Developed as part of a Selenium Automation Framework learning project focused on building an industry-standard, scalable UI automation framework.
