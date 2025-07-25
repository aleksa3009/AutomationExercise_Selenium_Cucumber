# Test Plan – AutomationExercise E-Commerce QA Automation

**Author:** Aleksa Aleksić  
**Date:** July 25, 2025  
**Project:** AutomationExercise E-Commerce QA Automation  
**Base URL:** https://automationexercise.com

---

## 1. Introduction
This test plan explains how we will automate functional UI tests for the AutomationExercise e-commerce website.
It defines what will be tested, how tests will be written and run, who is responsible, which environments will be used, as well as possible risks and success criteria.
Tests will be written in Java using Selenium WebDriver and Cucumber BDD, with TestNG for execution and ExtentReports for reporting.

---

## 2. Scope
**In Scope:**
- **Core User Flows:**
    - **User Registration & Login:** valid and invalid credential checks, error messages.
    - **Product Search & Browse:** search by keyword, category filters, pagination.
    - **Shopping Cart:** add products, update quantities, remove items.
    - **Checkout Process:** billing/shipping form validations, promo code application, order summary.
    - **Contact Us Form:** input validation, success/failure alerts.
- **Modules:** Home, Account (Login/Signup), Products, Cart, Checkout, Contact Us.
- **Test Data Variations:** multiple user profiles, product SKUs, boundary values (empty fields, special characters).

**Out of Scope:**
- Backend/API testing
- Performance/load/stress testing
- Mobile/responsive UI testing
- Security/accessibility scans

---

## 3. Objectives
- Verify that key user journeys work correctly from start to finish.
- Ensure UI elements display and behave correctly on supported browsers.
- Detect regressions early using automated tests in the CI pipeline.
- Provide detailed test documentation and maintainable code for portfolio use.

---

## 4. Roles & Responsibilities

| Role          | Name           | Responsibility                                                     |
|---------------|----------------|--------------------------------------------------------------------|
| QA Engineer   | Aleksa Aleksić | Draft and execute automated tests, maintain scripts and reporting. |
| Reviewer      | Peer/Lead      | Review feature files, code, and test results for accuracy.         |
| Product Owner | Stakeholder    | Approve test coverage, review and prioritize defects.              |

---

## 5. Test Items
Detailed coverage per module:

| Module       | Key Scenarios                                           | Positive Flows                        | Negative Flows                       |
|--------------|---------------------------------------------------------|---------------------------------------|--------------------------------------|
| Home         | Load homepage, carousel nav, footer links               | Elements visible, clickable links     | Broken links, missing images         |
| Login/Signup | Register new user, login existing user                  | Successful registration & login       | Duplicate email, invalid pwd formats |
| Products     | Search ("dress"), filter by category, sort by price     | Correct items returned, sorting works | No results scenario, malformed query |
| Cart         | Add 1–5 items, increase/decrease quantity, remove items | Cart updates reflect correctly        | Exceed stock, zero/negative qty      |
| Checkout     | Fill address, select country, apply promo code          | Order placed, confirmation page       | Required fields empty, invalid promo |
| Contact Us   | Fill name, email, message fields, submit                | Success confirmation appears          | Invalid email, blank message field   |

---

## 6. Test Strategy & Approach
1. **Framework Architecture:** Page Object Model (POM) with separate packages for pages, step definitions, runners, and utilities.
2. **BDD Layer:** Gherkin `.feature` files for readability, tagged with `@smoke`, `@regression`, `@sanity`.
3. **Parameterized Tests:** Use Cucumber Scenario Outlines with Examples table for data-driven scenarios.
4. **Browser Management:** WebDriverManager handles Chrome and Firefox drivers.
5. **Synchronization:** Explicit waits (WebDriverWait) for dynamic elements; use `explicitWait` value from config.
6. **Logging & Reporting:** Log4j2 for detailed logs; ExtentReports for interactive HTML dashboards.
7. **CI Integration:** GitHub Actions workflow triggers suite on push, archives reports as artifacts.

---

## 7. Environment & Tools
- **Operating Systems:** Linux Ubuntu 22.04 LTS
- **Browser Versions:** Google Chrome 138.0.7204.100 , Mozilla Firefox 141.0
- **Java:** Source/target 17, JDK 24 runtime
- **Build:** Maven 3.8.x
- **Test Framework:** Selenium 4.21.0, Cucumber 7.15.0, TestNG 7.8.0
- **IDE:** IntelliJ IDEA 2025.1.3
- **Logging:** Log4j2 2.22
- **Reporting:** ExtentReports 5.1.1
- **Version Control:** Git + GitHub
- **CI/CD:** GitHub Actions

---

## 8. Entry & Exit Criteria
**Entry Criteria:**
- Environment setup complete (JDK, Maven, IDE)
- Repository cloned, `pom.xml` resolved
- Config files in place (`config.properties`, `log4j2.xml`)
- DriverFactory and ConfigReader functional
- Initial feature files and runner configured

**Exit Criteria:**
- All critical scenarios executed and passed
- Reports generated and saved (
  `Reports/extentreport.html`, `Logs/test-log.log`)
- Defects logged in GitHub Issues with severity tags
- Final report completed

---

## 9. Risks & Mitigation
| Risk                        | Likelihood | Impact | Mitigation                                      |
|-----------------------------|------------|--------|-------------------------------------------------|
| Dynamic element locators    | Medium     | High   | Use robust XPath/CSS, explicit waits            |
| Flaky tests due to waits    | High       | Medium | Implement retry logic, avoid Thread.sleep       |
| Demo site downtime          | Low        | High   | Schedule tests at off-peak times, local mock    |
| Test data inconsistencies   | Low        | Medium | Validate JSON and properties before test run    |

---

## 10. Deliverables
- **Test Plan:** `TestPlan/AutomationExercise_Test_Plan.md`
- **Feature Files:** `features/*.feature`
- **Page Objects:** `src/main/java/pages/*.java`
- **Step Definitions:** `src/test/java/stepdefinitions/*.java`
- **Test Runner:** `src/test/java/runners/TestRunner.java`
- **Reports & Logs:** `Reports/extentreport.html`, `Logs/test-log.log`
- **Daily Reports:** `Reports/Daily_Report_<DD-MM-YYYY>.md`
- **Final Report:** `Reports/Final_Report.md`

---

## 11. Schedule
| Day | Activity                                                               | Duration |
|-----|------------------------------------------------------------------------|----------|
| 1   | Environment setup, Maven & IDE, config, DriverFactory & ConfigReader   | 7h       |
| 2   | Page objects, BaseTest, Hooks, logging & POM setup                     | 8h       |
| 3   | Write Login & Signup feature files and step definitions                | 8h       |
| 4   | Automate Cart & Checkout scenarios                                     | 7h       |
| 5   | Automate Search & Contact Us scenarios                                 | 7h       |
| 6   | Implement ExtentReports, run full suite, capture logs                  | 8h       |
| 7   | CI/CD integration, artifact storage, badge updates                     | 7h       |
| 8   | Finalize code, cleanup, portfolio packaging, demo video                | 8h       |

---
