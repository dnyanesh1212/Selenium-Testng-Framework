# 🚀 Selenium TestNG Automation Framework (Java)

A **robust, scalable, CI-ready Selenium TestNG automation framework** built using **Java**, designed with **real-world best practices** followed in enterprise QA teams.

---

## ✨ Key Features

- Data-driven testing using **Excel**
- Clean and rich reporting with **Extent Reports**
- **Retry mechanism** for flaky tests
- **Config-based execution**
- **Headless execution** (CI-friendly)
- **GitHub Actions CI pipeline**
- Thread-safe WebDriver management

---

## 🧰 Tech Stack

- **Language:** Java 11
- **Test Framework:** TestNG
- **Automation:** Selenium WebDriver
- **Build Tool:** Maven
- **Reporting:** Extent Reports
- **CI/CD:** GitHub Actions
- **Test Data:** Excel (Apache POI)

---

## 📂 Project Structure

```text
Selenium-Testng-Framework
│
├── .github/
│   └── workflows/
│       └── ci.yml                 # GitHub Actions CI pipeline
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/              # BaseTest (setup & teardown)
│       │   ├── driver/            # DriverFactory & DriverManager
│       │   ├── utils/             # Config, waits, screenshots, helpers
│       │   ├── reporter/          # Extent reporting utilities
│       │   ├── listeners/         # TestNG listeners
│       │   ├── dataProvider/      # Excel DataProvider logic
│       │   └── pages/             # Page classes
│       │   └── tests/             # Test classes
│       │
│       └── resources/
│           ├── configs/            # config.properties + env configs
│           ├── testdata/           # Excel test data
│           └── testng.xml          # TestNG suite
│
├── reports/                       # Extent Reports output
├── pom.xml
└── README.md

```
## ⚙️ Prerequisites

Ensure you have the following installed:

- Java 11
- Maven 3.8+
- Google Chrome / Firefox / Edge
- Git

Verify installation:
```
java -version
mvn -version
```

## ⚡ Getting Started

1️⃣ Clone the repository
```
git clone https://github.com/dnyanesh1212/Selenium-Testng-Framework.git
cd Selenium-Testng-Framework
```

2️⃣ Install dependencies
```
mvn clean install
```

▶️ Running Tests
- Run all tests
```
mvn clean test
```

- Run using TestNG suite
```
mvn clean test -Dsuite=smoke
```

(Configure suite selection inside pom.xml / testng.xml)

## 🧠 Configuration Management
📄 config.properties

Located at:
```
src/test/resources/configs/config.properties
```

## ⚙️ Configuration
Example : config.properties

```text
browser=chrome
env=QA
headless=true
inputExcel=TestData.xlsx
```
Override via Command Line

```text
mvn clean test -Dbrowser=chrome -Dheadless=false -Denv=DEV
```

Command-line values always override config values

## ▶️ How to Run Tests
Run all tests
```text
mvn clean test
```

Run specific TestNG suite
```text
mvn clean test -Dsuite=smoke
```

Run in headless mode
```text
mvn clean test -Dheadless=true
```

## 🔁 Data-Driven Testing (Excel)

- Single Excel sheet (Test Data)
- Multiple blocks for different test classes
- Each block starts with headers
- Only matching test class data is read

## Example Excel Structure
```text
ClassName        TestDescription     Username           Password
SampleTest       First sample test   user@gmail.com     Abc@123

ClassName        TestDescription     Title
RegressionTest   Regression test     Google
```
✔️ 1 row = 1 test execution
✔️ No unnecessary executions
✔️ Clean separation per test class

## 📊 Reporting

- Reports generated using Extent Reports
- Screenshots captured on final failure
- Reports stored under:

  📁 Location:
```
reports/
```

In CI runs, reports are uploaded as GitHub Actions artifacts

## 🔄 Retry Mechanism

- Retries only failed tests
- Retry count configurable
- Only final result is shown in report


## 📑 Data-Driven Testing (Excel)
📄 Excel File Location
```
src/test/resources/testdata/TestData.xlsx
```
🧩 Supported Excel Format (Single Sheet, Multiple Blocks)
```
ClassName | TestDescription | Username | Password
SampleTest | First sample test | user@gmail.com | Abc@123

ClassName | TestDescription | Title
RegressionTest | Regression test | Google
```

✅ How it works

- Framework reads only the block matching test class name

➡️ 1 row = 1 test execution

🧪 Example Test
```
@Test(dataProvider = "testData", dataProviderClass = DataProviderUtils.class)
public void sampleRegressionTest(Map<String, String> data) {

    String title = data.get("Title");

    DriverManager.getDriver().get("https://www.google.com/");
    Reporter.info("Test title is : " + title);
}
```

## 🧵 Parallel Execution Ready

- Thread-safe WebDriver (ThreadLocal)
- Safe for parallel execution
- Can be enabled via testng.xml

## 🧪 Browser Support

- Chrome ✅
- Firefox ✅
- Edge ✅

- Headless execution supported for all

## 🔄 CI/CD – GitHub Actions
📄 Workflow File
```
.github/workflows/ci.yml
```
**What CI does:**
- Runs on push / PR
- Installs Java & Maven
- Executes tests in headless mode
  Uploads Extent Report as artifact

💰 Cost:
- GitHub Actions is FREE for public repos
- Free minutes available for private repos too

**❗ Common Issues & Fixes**
Chrome fails in CI

- ✔️ Ensure headless mode is enabled
- ✔️ --no-sandbox & --disable-dev-shm-usage already handled

**Test skipped unexpectedly**

- ✔️ Check Excel block format
- ✔️ Ensure ClassName matches test class name exactly

## 🌱 Future Enhancements (Planned)

- Allure integration
- Docker support
- Selenium Grid support

## 🤝 Contribution

Feel free to:
- Fork the repo
- Create feature branches
- Raise PRs
- Suggest improvements

## ⭐ Best Practices Followed

- Thread-safe WebDriver using ThreadLocal
- No WebDriver instance variables in tests
- Centralized configuration management
- Clean separation of concerns
- CI-stable execution


## Author

Dnyaneshwar Dhawalshankh |
Senior QA Engineer | Automation
- 📍 Pune, India

## ⭐ Support

If you find this framework useful, please star ⭐ the repository
and feel free to fork or contribute.

**Happy Testing 🚀**

