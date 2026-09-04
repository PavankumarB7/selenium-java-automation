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


# XPath Axes

XPath axes locate elements based on their **relationship with the current/context node**.

## 1. Parent Axis

### Theory
`parent` selects the **immediate parent** of the current element.

**Direction:** one level up.

### Example

```text
Label
└── Input ← current
```

```xpath
//input/parent::label
```

Starting from `Input`, the XPath moves one level up to `Label`.

### Selenium example

```java
driver.findElement(
    By.xpath("//textarea[@name='my-textarea']/parent::label")
);
```

**Remember:** Parent = immediate element above.

---

## 2. Child Axis

### Theory
`child` selects the **direct children** of the current element.

**Direction:** one level down.

### Example

```text
Label ← current
├── Input
└── Span
```

```xpath
//label/child::input
```

Starting from `Label`, the XPath moves one level down and finds `Input`.

### Using `*`

```xpath
//label/child::*
```

`*` means **any element**.

Therefore, `child::*` means:

> Select any direct child element.

**Remember:** Child = directly below.

---

## 3. Descendant Axis

### Theory
`descendant` selects elements **anywhere below** the current element, at any depth.

### Example

```text
Form
└── Div
    └── Section
        └── Input
```

```xpath
//form/descendant::input
```

`Input` is not a direct child of `Form`, but it is a descendant.

### Child vs Descendant

```text
Form
├── Input        ← child
└── Div
    └── Input    ← descendant
```

- Child = direct / one level down
- Descendant = anywhere below / any depth

---

## 4. Ancestor Axis

### Theory
`ancestor` selects elements **above the current element at any level**.

### Example

```text
Form
└── Div
    └── Section
        └── Input ← current
```

```xpath
//input/ancestor::form
```

Starting from `Input`, the XPath moves upward through its ancestors and finds `Form`.

Ancestors are `Section`, `Div`, and `Form`.

### Parent vs Ancestor

- Parent = immediate element above
- Ancestor = any element above

---

## 5. Following-Sibling Axis

### Theory
`following-sibling` selects elements that:

1. Have the **same parent**
2. Come **after** the current element

### Example

```text
Div
├── Username ← current
├── Password
└── Email
```

```xpath
//input[@name='username']/following-sibling::input
```

`Password` and `Email` are following siblings of `Username`.

**Remember:** Same parent + after.

---

## 6. Preceding-Sibling Axis

### Theory
`preceding-sibling` selects elements that:

1. Have the **same parent**
2. Come **before** the current element

### Example

```text
Div
├── Username
├── Password
└── Email ← current
```

```xpath
//input[@name='email']/preceding-sibling::input
```

`Username` and `Password` are preceding siblings of `Email`.

**Remember:** Same parent + before.

---

## 7. Following Axis

### Theory
`following` selects nodes that occur **later in document order**, outside the current node's subtree.

They do not need to have the same parent.

### Example

```text
Div
├── Password label ← current
└── ...

Another Div
└── Password input
```

```xpath
//label[text()='Password']/following::input
```

The input occurs later in the document, so it can be selected using the `following` axis.

### Following vs Following-Sibling

- Following-sibling = same parent + after
- Following = later in document, regardless of parent

---

## 8. Preceding Axis

### Theory
`preceding` selects nodes that occur **earlier in document order**, excluding ancestors.

### Example

```text
Div
├── Username label
├── Username input
└── ...

Another Div
├── Password label
└── Password input ← current
```

```xpath
//input[@name='password']/preceding::label
```

`Username label` occurs earlier in the document and is not an ancestor, so it belongs to the `preceding` axis.

### Important

Ancestors are excluded from `preceding`.

```text
Form
└── Div
    └── Input ← current
```

`Form` and `Div` are ancestors, so they are **not** returned by `preceding`.

**Remember:** Earlier in document order + excluding ancestors.

---

## 9. Self Axis

### Theory
`self` selects the **current element itself**.

It does not move.

### Example

```text
Label ← current
```

```xpath
//label/self::label
```

The XPath remains on the same `Label`.

**Remember:** Self = current element.

---

# Quick Reference

| Axis | Relationship |
|---|---|
| `parent` | Immediate parent — one level up |
| `child` | Direct children — one level down |
| `ancestor` | Any element above |
| `descendant` | Any element below |
| `following-sibling` | Same parent + after |
| `preceding-sibling` | Same parent + before |
| `following` | Later in document order, outside subtree |
| `preceding` | Earlier in document order, excluding ancestors |
| `self` | Current element itself |

---

# Important Comparisons

### Parent vs Ancestor

```text
A
└── B
    └── C ← current
```

- Parent → `B`
- Ancestors → `B`, `A`

**Parent = immediate. Ancestor = any level above.**

### Child vs Descendant

```text
A ← current
├── B
│   └── C
└── D
```

- Children → `B`, `D`
- Descendants → `B`, `C`, `D`

**Child = direct only. Descendant = any depth.**

### Following-Sibling vs Following

- Following-sibling = same parent + after
- Following = later in document order, regardless of parent

### Preceding-Sibling vs Preceding

- Preceding-sibling = same parent + before
- Preceding = earlier in document order, excluding ancestors

---

# Simple Mental Model

```text
                 ancestor
                    ↑
                    |
preceding ←       SELF       → following
                    |
                    ↓
                descendant
```

Sibling axes add the **same-parent** condition:

```text
following-sibling → same parent + after
preceding-sibling → same parent + before
```

Also:

```text
parent → one level up
child  → one level down
self   → stay on current element
```

---

# Practical Selenium Pattern

```java
driver.findElement(
    By.xpath("AXIS_EXPRESSION")
);
```

Example:

```java
driver.findElement(
    By.xpath("//textarea[@name='my-textarea']/parent::label")
);
```

Process:

1. Find the `textarea`.
2. Treat it as the current node.
3. Move to its parent.
4. Select the parent if it is a `label`.

## Locator Strategy Note

XPath axes are one locator technique. Do not force an axis into every locator.

Prefer a simple, stable locator when one is available:

```xpath
//input[@name='username']
```

Use an axis when the relationship helps identify the target:

```xpath
//textarea[@name='my-textarea']/parent::label
```

The goal is to understand the relationship and choose a stable locator.

