# 🚀 Saucedemo End-to-End Automation Framework

> Production-ready UI automation framework using **Selenide + TestNG + Maven**, integrated with **GitHub Actions (CI/CD)**, **Allure reporting**, and **automated HTML email notifications with charts**.

---

## 🔥 Why This Project Stands Out

* ✔ End-to-end user journey automation (Login → Cart → Checkout)
* ✔ CI/CD with **push**, **schedule (cron)**, and **manual** triggers
* ✔ **Allure** reports (artifacts) with step-level insights
* ✔ **HTML email reports** with dynamic pie chart 📊
* ✔ **Headless execution** for CI environments
* ✔ Clean, scalable **Page Object Model (POM)** architecture

---

## 🧠 What This Demonstrates

* Framework design (POM + utilities + data providers)
* CI/CD pipeline design and reliability considerations
* Reporting, monitoring, and stakeholder communication
* Real-world regression flow for an e-commerce app

---

## ⚙️ CI/CD Pipeline

### Triggers

* Push to `main`
* Daily schedule (cron)
* Manual run (`workflow_dispatch`)

### Flow

```text
Push / Schedule / Manual
        ↓
GitHub Actions (JDK 17)
        ↓
Build (Maven)
        ↓
Test Execution (Headless)
        ↓
Allure Results → HTML Report
        ↓
Summary Extraction
        ↓
Email Notification 📧
```

---

## 📸 Execution Proof

The following screenshots provide visual confirmation of the framework in action, covering CI/CD execution, reporting, and automated notifications.

These demonstrate that the automation pipeline is fully functional—from test execution to reporting and result communication.

---

### 🔹 CI Pipeline
<img width="1895" height="849" alt="image" src="https://github.com/user-attachments/assets/8b98ba36-485b-4a93-8339-c264925357c3" />

> Shows successful execution of the CI pipeline via GitHub Actions, including build, test run, reporting, and email notification steps.

---

### 🔹 Allure Dashboard
<img width="1915" height="956" alt="image" src="https://github.com/user-attachments/assets/8bd2375d-ca90-4459-9f78-e1f102efe164" />

> Provides a high-level summary of test results with pass/fail distribution and overall execution status.

---

### 🔹 Allure Test Details
<img width="1088" height="947" alt="image" src="https://github.com/user-attachments/assets/be2e511c-6342-40de-8d3c-5fe46eeca30d" />

> Displays detailed test execution steps, enabling easier debugging and analysis of test behavior.

---

### 🔹 Email Report (HTML + Chart)
<img width="1061" height="893" alt="image" src="https://github.com/user-attachments/assets/45f80dc7-614a-40d8-a72d-772867b5f7b8" />

> Automated email notification containing test summary, pass/fail metrics and visual chart representation.

---

### 🔹 Project Structure (IDE)
<img width="267" height="717" alt="image" src="https://github.com/user-attachments/assets/26736dea-8fa8-4b84-b3c3-0f0895933f69" />

> Illustrates the organized project structure following Page Object Model and modular design principles.

---

## 🧪 Automated Test Scenarios Covered

### 🔹 Authentication & Login
- ✔ Verify successful login with valid credentials  
- ✔ Validate error message for invalid credentials  
- ✔ Validate locked-out user login restriction  
- ✔ Ensure session is maintained after login  

---

### 🔹 Inventory / Product Page
- ✔ Verify products are displayed correctly after login  
- ✔ Validate sorting functionality (Low → High price)  
- ✔ Verify product details (name, price, add/remove button)  
- ✔ Validate adding multiple items to cart  

---

### 🔹 Cart Functionality
- ✔ Verify items added are reflected in cart  
- ✔ Validate cart badge count updates dynamically  
- ✔ Verify item removal from cart  
- ✔ Validate cart page displays correct items  

---

### 🔹 Checkout Workflow
- ✔ Validate navigation from cart to checkout  
- ✔ Verify user details form submission  
- ✔ Validate error handling for missing fields  
- ✔ Ensure checkout continues to overview page  

---

### 🔹 Order Completion (End-to-End)
- ✔ Complete full purchase flow successfully  
- ✔ Validate success message after order completion  
- ✔ Ensure cart is cleared after checkout  
- ✔ Verify end-to-end user journey integrity  
---

## 📂 Project Structure (Detailed)

```text
src
├── main
│   └── java
│       ├── pages
│       │   ├── LoginPage.java        → Login actions & validations
│       │   ├── InventoryPage.java    → Products, sorting, cart entry
│       │   ├── CartPage.java         → Cart verification & removal
│       │   └── CheckoutPage.java     → User info & order completion
│       │
│       ├── utils
│       │   ├── ConfigManager.java    → Reads env/config properties
│       │   ├── ExcelUtils.java       → (Optional) data-driven support
│       │   └── WaitUtils.java        → Custom waits (if needed)
│       │
│       ├── config
│       │   └── config.properties     → Base URL, browser, timeouts
│       │
│       └── constants
│           └── FrameworkConstants.java → Reusable constants
│
├── test
│   └── java
│       ├── tests
│       │   ├── LoginTests.java       → Login scenarios
│       │   ├── CartTests.java        → Cart validations
│       │   ├── CheckoutTests.java    → Checkout flow
│       │   └── E2ETests.java         → Full E2E scenarios
│       │
│       ├── base
│       │   └── BaseTest.java         → Setup (headless for CI), teardown
│       │
│       ├── dataproviders
│       │   └── LoginDataProvider.java → Data-driven inputs
│       │
│       └── listeners (optional)
│           └── Allure/TestNG listeners
│
└── resources
    └── testdata
```

---

## 📊 Reporting

### 🔹 Allure

* Dashboard + trends + step logs
* Failure diagnostics
  📌 Available in **Actions → Artifacts → allure-report**

### 🔹 Email (Advanced)

* Total / Passed / Failed / Broken
* Pie chart visualization
* Direct link to the workflow run

---

## 📅 Scheduled Execution

```text
Runs daily at 6:30 PM IST (cron in UTC)
```
---

## 🛠️ Tech Stack

| Layer          | Tool                      |
| -------------- | ------------------------- |
| Language       | Java                      |
| UI Automation  | Selenide                  |
| Test Framework | TestNG                    |
| Build          | Maven                     |
| CI/CD          | GitHub Actions            |
| Reporting      | Allure                    |
| Notification   | SMTP (Gmail App Password) |

---

## ▶️ Run Locally

```bash
git clone https://github.com/Srirams02/Saucedemo-End-to-End-Automation-framework.git
cd Saucedemo-End-to-End-Automation-framework
mvn clean test
```

Generate report:

```bash
mvn io.qameta.allure:allure-maven:serve
```

---

## 🔐 GitHub Secrets

| Name           | Purpose            |
| -------------- | ------------------ |
| EMAIL_USERNAME | Sender Gmail       |
| EMAIL_PASSWORD | Gmail App Password |
| EMAIL_TO       | Recipient(s)       |

---

## 🧠 Design Decisions

* **Selenide over Selenium**: built-in waits, concise API, reduced flakiness
* **Headless in CI**: faster, no UI dependency, stable in Linux runners
* **Allure**: rich, industry-standard reporting
* **Email summaries**: instant visibility for stakeholders

---

## 🔮 Future Enhancements

* Env profiles (dev/qa/prod)
* Dockerized test runs
* API + UI hybrid flows

---

## 👨‍💻 Author

**Sriram S**

- 🔗 GitHub: https://github.com/Srirams02 
- 💼 LinkedIn: www.linkedin.com/in/sriram-s-a6947423a

---

## ⭐ Final Note

This repository demonstrates a complete automation pipeline integrating UI testing, CI/CD workflows, reporting, and automated notifications, reflecting real-world SDET and DevOps practices.
