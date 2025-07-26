# Daily Report – 26-07-2025 (Day 2)

---

## Activities:

- Created Page Object classes: `LoginSignupPage`, `HomePage`, `CartPage`, `ContactUsPage`, `CheckoutPage`, `ProductsPage`.
- Implemented `BaseTest` class to initialize and quit WebDriver sessions.
- Developed Cucumber Hooks (`@Before`, `@After`) for test setup and teardown, including screenshot capture on failure.
- Set up utility classes: `WaitUtils`, `ScreenshotUtils`, and `LoggerUtils`.
- Finalized folder structure and committed all Day 2 source code and configurations.

---

## Environment:

- **OS:** Linux Ubuntu 22.04 LTS
- **IDE:** IntelliJ IDEA
- **JDK:** 17 (compiled with Java 17, runtime Java 24 installed)
- **Browsers:** Chrome and Firefox (via WebDriverManager)
- **Build Tool:** Apache Maven 3.9.11
- **Test Framework:** TestNG + Cucumber
- **Logging:** Log4j2 configured and tested

---

## Issues:

- Minor confusion on organizing utils classes and their usage in early tests.
- The page elements are poorly labeled, lacking IDs or `#` selectors and with almost no classes or `.` selectors. Most locators rely on XPath or contains, which complicates maintaining stable test automation.
- Faced difficulties writing utility classes (`WaitUtils`, `ScreenshotUtils` and `LoggerUtils`), so I used examples and templates from internet sources for help.
- Will delay using some utility functions until I implement tests and get more familiar with them.

---

## Next Steps:

- Write scenarios (positive and negative) for `LoginSignup` and `Checkout`.
- Add `@tags` to scenarios for selective test execution.
- Implement step definition classes: `LoginSignupSteps.java` and `CheckoutSteps.java`.
- Integrate screenshot capture and logging into step failures.
- Finalize and commit daily report for Day 3.
