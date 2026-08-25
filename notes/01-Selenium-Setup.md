# Selenium Java Setup

## 1. Prerequisites

- Java 21
- Maven
- VS Code
- Java extensions for Java development
- Google Chrome

## 2. Create the Maven Project

Create a Maven project for Selenium Java automation and open it in VS Code.

Maven manages the project's dependencies and build configuration through `pom.xml`.

## 3. Add Selenium Dependency

Add Selenium WebDriver as a Maven dependency in `pom.xml`.

The Selenium version currently used in this project is:

```text
4.23.0
```

Example:

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.23.0</version>
</dependency>
```

After updating `pom.xml`, allow Maven/VS Code to download and load the dependencies.

## 4. Project Structure

```text
selenium-java/
│
├── src/
│   └── test/
│       └── java/
│           └── locators/
│
├── notes/
│   ├── setup.md
│   └── locators.md
│
├── pom.xml
└── README.md
```

## 5. Create the First Selenium Class

Create a Java class under `src/test/java`.

Example:

```java
package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("your-test-url");
        driver.manage().window().maximize();
    }
}
```

### Important Statements

```java
WebDriver driver = new ChromeDriver();
```

Creates a Chrome browser session and stores it in a `WebDriver` reference.

```java
driver.get("your-test-url");
```

Navigates the browser to the specified URL.

```java
driver.manage().window().maximize();
```

Maximizes the browser window.

## 6. Run the First Test

Run the Java class from VS Code.

A successful execution should:

1. Start Chrome.
2. Open the specified test URL.
3. Maximize the browser window.

## 7. Basic Troubleshooting

If VS Code suddenly stops recognizing Java features such as:

- `PSVM` / `main()`
- Java code completion
- Running the Java class
- Maven/project changes

first try restarting VS Code.

If the problem continues, then investigate the Java, Maven, or project configuration.

## 8. Verify Selenium Version

The Selenium version used by the project can be checked in `pom.xml`.

Look for:

```xml
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>4.23.0</version>
```

The `<version>` value is the Selenium version used by the project.

## Key Points

- Java is used for Selenium automation.
- Maven manages Selenium dependencies.
- `pom.xml` contains the Maven project configuration.
- `WebDriver` is used to control the browser.
- `ChromeDriver` provides the Chrome browser implementation.
- Selenium classes are imported as required.
