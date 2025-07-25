# Daily Report – 25-07-2025 (Day 1)

---

## Activities:

- Installed JDK, Maven, and IntelliJ IDEA.
- Initialized GitHub repository for the project.
- Created `pom.xml` with dependencies: `selenium-java`, `cucumber-java`, `testng`, `extent-reports`, `log4j2`, `webdrivermanager`.
- Added configuration files: `config.properties` and `log4j2.xml` under `src/main/resources/config/`.
- Implemented `DriverFactory.java` and `ConfigReader.java` in the `utils` package.
- Created and committed basic `.gitignore`, folder structure, and `testng.xml` for running tests.
- Ran Maven build (`mvn clean install`), build succeeded.
- Drafted first daily report and test plan.

---

## Environment:

- **OS:** Linux Ubuntu 22.04 LTS
- **IDE:** IntelliJ IDEA
- **JDK:** 17 (compiled with Java 17, runtime Java 24 installed)
- **Browsers:** Chrome and Firefox (via WebDriverManager)
- **Build Tool:** Apache Maven 3.9.11
- **Test Framework:** TestNG + Cucumber
- **Logging:** Log4j2

---

## Issues:

- Visual glitch in IntelliJ showing `.idea/` and `target/` folders in red despite being in `.gitignore`.
- Initial challenges configuring `testng.xml`, `ConfigReader.java` and folder structure.

---

## Next Steps:

- Create page classes: `LoginPage`, `SignupPage`, `HomePage`, `CartPage`, etc.
- Implement base classes: `BaseTest` and Cucumber Hooks (`@Before`, `@After`).
- Set up `utils` folder with helper classes and logging initialization.
- Finalize and commit daily report for Day 2.
