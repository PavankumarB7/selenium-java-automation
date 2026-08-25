# Selenium WebDriver — Introduction

## 1. What is Selenium WebDriver?

Selenium is a tool/framework used for **web browser automation**.

**WebDriver** is one of the components of Selenium.

In Java:

- WebDriver is a **Java interface**.
- WebDriver provides the API used by Java automation code to communicate with web browsers.
- It allows us to automate browser actions such as opening URLs, finding elements, entering data, clicking buttons, validating information, and closing the browser.

---

## 2. WebDriver Hierarchy

The basic hierarchy is:

```text
WebDriver (Interface)
        ↑
RemoteWebDriver (Class)
        ↑
ChromeDriver / FirefoxDriver / EdgeDriver
```

Browser-specific drivers provide the implementation for their respective browsers.

Examples:

- `ChromeDriver` → Chrome
- `FirefoxDriver` → Firefox
- `EdgeDriver` → Edge

This is connected to Java's **interface and inheritance concepts**.

Example:

```java
WebDriver driver = new ChromeDriver();
```

Here:

- `WebDriver` → interface/reference type
- `ChromeDriver` → implementation class
- `new ChromeDriver()` → creates the ChromeDriver object

---

## 3. WebDriver and Browser Relationship

Java code does not directly contain browser-specific automation logic.

The basic relationship is:

```text
Java Selenium Code
        ↓
     WebDriver
        ↓
   ChromeDriver
        ↓
      Chrome
```

For Edge:

```text
Java Selenium Code
        ↓
     WebDriver
        ↓
    EdgeDriver
        ↓
      Edge
```

The browser-specific driver handles communication with the corresponding browser.

---

## 4. Why Can WebDriver Work With Different Browsers?

WebDriver provides a **common API** for browser automation.

For example:

```java
WebDriver driver = new ChromeDriver();
```

can be changed to:

```java
WebDriver driver = new EdgeDriver();
```

The rest of the WebDriver code can generally remain the same.

This is possible because browser-specific drivers provide implementations of the WebDriver interface.

Therefore:

```text
WebDriver
   ↓
Common browser automation methods
   ↓
ChromeDriver / EdgeDriver / FirefoxDriver
```

---

## 5. W3C WebDriver Protocol

Selenium 4 uses the **W3C WebDriver standard/protocol** for communication between Selenium and browsers/browser drivers.

> Selenium 4 follows the W3C WebDriver standard for browser automation communication.

For current Selenium learning, understand the purpose of the protocol rather than its internal implementation details.

---

## 6. Maven — Selenium Java

### What is Maven?

**Maven** is a project/build management tool used to manage dependencies and configuration in a Java project.

For Selenium, Maven makes it easier to add and manage Selenium libraries instead of manually downloading JAR files.

### Why Use Maven?

Without Maven, Selenium JAR files would need to be downloaded and attached to the Java project manually.

With Maven, the required dependencies are managed through the Maven project configuration.

### `pom.xml`

A Maven project uses a file called:

```text
pom.xml
```

This file contains project dependencies and Maven configuration.

For Selenium, the Selenium dependency is added to `pom.xml`.

### Group ID and Artifact ID

When creating a Maven project:

- **Group ID** → identifies the project/group/organization
- **Artifact ID** → identifies the project/application

These form part of the Maven project's identification.

### Selenium Dependency

Maven can download and manage Selenium based on the dependency specified in `pom.xml`.

Conceptually:

```text
Maven Project
     ↓
  pom.xml
     ↓
Selenium Dependency
     ↓
Maven downloads/manages required library
```

---

## 7. Basic Selenium Automation Script

A basic Selenium program looks like:

```java
WebDriver driver = new ChromeDriver();

driver.get("https://example.com");

System.out.println(driver.getTitle());

driver.quit();
```

### What Each Line Does

```java
WebDriver driver = new ChromeDriver();
```

Creates a ChromeDriver object and assigns it to a WebDriver reference.

```java
driver.get("https://example.com");
```

Opens the specified URL in the browser.

```java
System.out.println(driver.getTitle());
```

Gets the current page title and prints it.

```java
driver.quit();
```

Closes the browser and ends the WebDriver session.

---

## Key Takeaways

1. Selenium is used for web browser automation.
2. WebDriver is a **Java interface**.
3. `ChromeDriver`, `FirefoxDriver`, and `EdgeDriver` are browser-specific implementations.
4. WebDriver provides common browser automation methods.
5. `WebDriver driver = new ChromeDriver();` uses an interface reference with an implementation class.
6. WebDriver provides a way for Java code to communicate with browsers.
7. Selenium 4 uses the **W3C WebDriver standard/protocol**.
8. The tutorial uses Eclipse, while this project uses **VS Code**.
9. Maven manages Selenium dependencies through `pom.xml`.
10. The basic Selenium flow is:

```text
Create driver
      ↓
Open URL
      ↓
Perform actions / validations
      ↓
Close browser
```
