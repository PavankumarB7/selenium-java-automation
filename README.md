# Selenium Java Automation Practice

A hands-on Selenium WebDriver automation practice project using Java and Maven.

This repository contains topic-wise Selenium learning, practical implementations, and notes while learning Selenium WebDriver with Java.

## Tech Stack

- Java 21
- Selenium WebDriver 4.23.0
- Maven
- VS Code
- Google Chrome
- Git & GitHub

## Project Structure

```text
selenium-java/
│
├── src/
│   └── test/
│       └── java/
│           └── locators/
│               ├── Locators.java
│               └── LocatorsDemoQA.java
│
├── notes/
│   ├── setup.md
│   └── locators.md
│
├── pom.xml
└── README.md
```

## Topics Covered

### Selenium Setup

- Selenium WebDriver setup
- Maven project setup
- ChromeDriver
- Basic browser automation

### Locators

- ID
- Name
- Link Text
- Partial Link Text
- Class Name
- Tag Name
- CSS Selector
- XPath

More Selenium topics will be added progressively.

## Practice Implementations

### `Locators.java`

Contains the locator implementation following the instructor's example.

The original practice uses the OpenCart demo website.

### `LocatorsDemoQA.java`

Contains the locator implementation using DemoQA as a working alternative when the OpenCart demo website is unavailable.

Both implementations are kept intentionally for learning and comparison.

## Documentation

Detailed topic-wise notes are maintained in the `notes` folder.

- `setup.md` — Selenium project setup reference
- `locators.md` — Selenium locator notes

## Selenium Learning Progress

| Topic                                                                | Status       |
| -------------------------------------------------------------------- | ------------ |
| Selenium Introduction & Environment Setup                            | ✅ Completed |
| Selenium Locators — ID, Name, LinkText, PartialLinkText, Class & Tag | ✅ Completed |
| Selenium Locators — CSS Selector                                     | ⏳ Upcoming  |
| Selenium Locators — XPath, XPath Functions, XPath Types              | ⏳ Upcoming  |
| Selenium Locators — XPath Axes, SelectorsHub                         | ⏳ Upcoming  |
| Selenium WebDriver Methods                                           | ⏳ Upcoming  |
| Selenium WebDriver Waiting Methods                                   | ⏳ Upcoming  |
| Selenium WebDriver Methods — Browser & Navigation Commands           | ⏳ Upcoming  |
| Handling Check Boxes & Different Types of Alerts                     | ⏳ Upcoming  |
| Handling Frames, iFrames & Nested iFrames                            | ⏳ Upcoming  |
| Handling Different Types of Drop-downs                               | ⏳ Upcoming  |
| Handling Auto-suggest Dropdown & Static Web Table                    | ⏳ Upcoming  |
| Handling Dynamic Pagination Web Table                                | ⏳ Upcoming  |
| Handling Date Pickers                                                | ⏳ Upcoming  |
| Mouse Actions — Action vs Actions                                    | ⏳ Upcoming  |
| Keyboard Actions, Sliders, Tabs & Windows                            | ⏳ Upcoming  |
| JavaScriptExecutor, Scrolling Pages & Upload Files                   | ⏳ Upcoming  |
| Screenshots, Headless, SSL, Ad Block & Extensions                    | ⏳ Upcoming  |
| Handling Broken Links, SVG Elements & Shadow DOM                     | ⏳ Upcoming  |
| Data Driven Testing — Part 1                                         | ⏳ Upcoming  |
| Data Driven Testing — Part 2                                         | ⏳ Upcoming  |

## How to Run

1. Clone the repository.
2. Open the project in VS Code.
3. Make sure Java and Maven are configured.
4. Allow Maven to download the project dependencies.
5. Open the required Java class under:

```text
src/test/java
```

6. Run the class from VS Code.

## Learning Approach

The project is developed topic by topic.

For each Selenium topic:

1. Learn the concept.
2. Watch the corresponding instructor lesson.
3. Implement the concept in Java.
4. Practice it on a working website.
5. Maintain topic-wise notes.
6. Commit the implementation to GitHub.
