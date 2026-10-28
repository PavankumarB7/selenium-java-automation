# Page Object Model

**Page Object Model (POM)** is a design pattern in Selenium that separates web page locators and interaction methods from test logic by maintaining them in separate page classes.

**Purpose:** Improves code reusability, maintainability, and separation of concerns.


## 1. Problems Without POM

1. **Duplication of locators** — the same locator may be repeated across multiple test methods.
2. **Maintenance difficulties** — when a locator changes, multiple test methods may need updating.
3. **Poor separation of concerns** — test logic and page interactions are mixed together.

## 2. Steps to Create a Page Object Class

1. **Constructor**
   - Receives the WebDriver instance.
   - Stores the driver in the page object's instance variable.
   - Constructor name must be the same as the class name.

2. **Locators**
   - Identify web elements using locators such as XPath or CSS selectors.

3. **Action Methods**
   - Use locators to find elements and perform actions such as `sendKeys()` and `click()`.

## 3. Structure of POM

1. **Page Object Classes**
   - Contain page locators and action methods.

2. **Test Classes**
   - Contain test methods, call page methods, and perform validations using assertions.

## 4. Approaches to Creating Page Object Classes

1. **Without PageFactory** — uses `By` locators and `driver.findElement()`.
2. **With PageFactory** — uses `@FindBy` annotations and `PageFactory.initElements()`.

## 5. Without POM vs POM Without PageFactory vs POM With PageFactory

| Point                            | Without POM                              | POM Without PageFactory                  | POM With PageFactory                     |
|----------------------------------|------------------------------------------|------------------------------------------|------------------------------------------|
| Locators                         | Usually in test class                    | In page class using `By`                 | In page class using `@FindBy`            |
| Page interactions                | In test class                            | In page class                            | In page class                            |
| Test logic and page interactions | Mixed together                           | Separated                                | Separated                                |
| Element interaction              | Usually `driver.findElement(...)`        | `driver.findElement(...)`                | Uses `WebElement` variables              |
| Maintenance                      | Can be difficult when code is duplicated | Easier through centralized page locators | Easier through centralized page locators |
| Main idea                        | Direct test implementation               | POM using `By` locators                  | POM using PageFactory                    |

## 6. Why Use POM?

- Separates page interactions from test logic.
- Reduces duplication of locator and interaction code.
- Makes locator maintenance easier.
- Allows multiple tests to reuse page methods.

## 7. Important Interview Point

**PageFactory is optional in POM.** POM is a design pattern that organizes page interactions separately from test logic. PageFactory is a Selenium mechanism for initializing page elements declared using annotations such as `@FindBy`.