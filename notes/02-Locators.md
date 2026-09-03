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

# XPath

XPath is used to locate elements in the DOM.

DOM = Document Object Model

# Types of XPath

1. Absolute XPath (full XPath)

   Example:

   `/html/body/header/div/div/div[2]/div/input`

2. Relative XPath (partial XPath)

   Example:

   `//*[@name="search"]`

## Which XPath is preferred?

**Relative XPath** is generally preferred over absolute XPath because it is shorter and less dependent on the exact DOM hierarchy.

# Difference between Absolute XPath and Relative XPath

| Absolute XPath                                    | Relative XPath                                                       |
| ------------------------------------------------- | -------------------------------------------------------------------- |
| Starts with `/`, representing the root node       | Starts with `//`                                                     |
| Traverses through the DOM hierarchy from the root | Can locate an element based on attributes, text, or other conditions |
| More dependent on the DOM structure               | Generally less dependent on the exact DOM structure                  |

# Approaches for Relative XPath

## 1. Automatically

Relative XPath can be generated using DevTools or tools such as SelectorsHub.

Example:

```xpath
//img[@title='Your Store']
```

Automatically generated full XPath may look like:

```xpath
/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]
```

## 2. Manually

A tester can create their own XPath based on the available attributes, text, or structure.

Syntax:

```xpath
//tagname[@attribute='value']
```

or

```xpath
//*[@attribute='value']
```

# XPath with Inner Text

XPath can locate an element based on its inner text using `text()`.

Examples:

```xpath
//a[text()='Desktops']
```

```xpath
//a[text()='MacBook']
```

## Inner Text vs Link Text

**Link Text** is specifically used with links (`<a>` elements).

**Inner text** can be used to locate elements based on their visible text.

Therefore, link text can be part of an element's inner text, but not all inner text is link text.

# XPath with `contains()`

`contains()` is useful when only part of an attribute value or text is stable.

Example:

```xpath
//input[contains(@placeholder, 'Sea')]
```

For example, if the placeholder value is:

```text
Search
```

the XPath:

```xpath
//input[contains(@placeholder, 'Sea')]
```

can match it because `Sea` is contained within `Search`.

# XPath with `starts-with()`

`starts-with()` is useful when the beginning of an attribute value or text is stable.

Example:

```xpath
//input[starts-with(@placeholder, 'Sea')]
```

If the placeholder starts with `Sea`, this XPath can locate the element.

# Difference between `contains()` and `starts-with()`

| `contains()`                                | `starts-with()`                                     |
| ------------------------------------------- | --------------------------------------------------- |
| Matches when the value appears **anywhere** | Matches when the value appears at the **beginning** |
| `contains(@placeholder, 'Sea')`             | `starts-with(@placeholder, 'Sea')`                  |

# Handling Dynamic Attributes

When an attribute value changes dynamically, avoid depending on the complete changing value if a stable portion is available.

Example:

```xpath
//*[@id='start' or @id='stop']
```

```xpath
//*[contains(@id, 'st')]
```

```xpath
//*[starts-with(@id, 'st')]
```

The important idea is:

**Identify the stable part of the attribute and build the XPath around that stable part.**

# Chained XPath

A chained XPath can be used when the target element does not have a useful attribute or inner text, but its relationship with another element provides a reliable path.

Example:

```xpath
//div[@id='logo']/a/img
```

This locates the `img` element through the `div` with `id='logo'`, then the `a`, then the `img`.

---

# XPath Examples from Practice

The `XPathDemo.java` practice file demonstrates:

- Relative XPath with a single attribute
- Relative XPath with multiple attributes
- `and` operator
- `or` operator
- `text()`
- `contains()`
- `starts-with()`
- Chained XPath

Examples:

```java
driver.findElement(By.xpath("//input[@placeholder='Search']"))
      .sendKeys("Canon");
```

```java
driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']"))
      .sendKeys("laptop");
```

```java
driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']"))
      .sendKeys("Tablets");
```

```java
driver.findElement(By.xpath("//input[@name='search' or @placeholder='Search']"))
      .sendKeys("Tablets");
```

```java
driver.findElement(By.xpath("//*[text()='MacBook']")).click();
```

```java
boolean displayStatus =
    driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
```

```java
String value =
    driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
```

```java
driver.findElement(By.xpath("//input[contains(@placeholder, 'Sea')]"))
      .sendKeys("Desktops");
```

```java
driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]"))
      .sendKeys("Desktops");
```

```java
boolean status =
    driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
```
