# Selenium Locators

## What is a Locator?

A locator is used by Selenium to identify a web element on a web page.

Selenium provides different locator strategies to identify elements.

### Types of Locators

- ID
- Name
- Link Text
- Partial Link Text
- Class Name
- Tag Name
- CSS Selector
- XPath

---

# `findElement()`

`findElement()` is used to find a single web element.

```java
WebElement logo = driver.findElement(By.id("logo"));
```

It returns:

```java
WebElement
```

---

# `findElements()`

`findElements()` is used to find one or more web elements.

```java
List<WebElement> links =
    driver.findElements(By.tagName("a"));
```

It returns:

```java
List<WebElement>
```

---

# Three Scenarios

## Scenario 1: Locator matches one web element

```text
findElement(locator)
    → WebElement

findElements(locator)
    → List<WebElement> containing 1 element
```

Example:

```java
WebElement logo =
    driver.findElement(By.id("logo"));
```

If `id="logo"` identifies only one element, `findElement()` returns that
element.

Using `findElements()` with the same locator would return a list
containing that one element.

---

## Scenario 2: Locator matches multiple web elements

```text
findElement(locator)
    → first matching WebElement

findElements(locator)
    → List<WebElement> containing all matching elements
```

Example:

```java
List<WebElement> links =
    driver.findElements(By.tagName("a"));

System.out.println("Total number of links: "
        + links.size());
```

If the page contains 30 `<a>` elements, the list contains 30 elements.

---

## Scenario 3: Locator does not match any element

```text
findElement(locator)
    → NoSuchElementException

findElements(locator)
    → empty List
```

Example:

```java
List<WebElement> elements =
    driver.findElements(By.id("doesNotExist"));

System.out.println(elements.size());
```

Output:

```text
0
```

---

# `findElement()` vs `findElements()`

| Situation        | `findElement()`             | `findElements()`                    |
| ---------------- | --------------------------- | ----------------------------------- |
| One match        | `WebElement`                | `List<WebElement>` with 1 element   |
| Multiple matches | First matching `WebElement` | `List<WebElement>` with all matches |
| No match         | `NoSuchElementException`    | Empty `List`                        |

---

## Key Points

- A locator identifies a web element on a page.
- `findElement()` returns a `WebElement`.
- `findElements()` returns `List<WebElement>`.
- `findElements()` is useful when working with multiple matching elements.

# CSS Selector

CSS - Cascading Style Sheets

| CSS Selector Type           | Syntax                             |
| --------------------------- | ---------------------------------- |
| **Tag + ID**                | `tag#id`                           |
| **Tag + Class**             | `tag.classname`                    |
| **Tag + Attribute**         | `tag[attribute='value']`           |
| **Tag + Class + Attribute** | `tag.classname[attribute="value"]` |
