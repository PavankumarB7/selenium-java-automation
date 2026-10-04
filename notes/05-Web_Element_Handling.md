# Web Element Handling

## Checkboxes

Checkboxes are form elements that can be selected or unselected.

### Selecting a Specific Checkbox

Use `click()` on the required checkbox element.

### Selecting Multiple Checkboxes

Use `findElements()` to locate multiple checkbox elements.

The returned `List<WebElement>` can be processed using a loop.

### Selecting the Last N Checkboxes

Formula:

`Total number of checkboxes - Number of checkboxes to select = Starting index`

Remember that List indexing starts from `0`.

### Selecting the First N Checkboxes

Use a loop starting from index `0` and continue for the required number of checkboxes.

### Unselecting Checkboxes

Use `isSelected()` to check whether a checkbox is selected.

If it is selected, use `click()` to unselect it.

# Frames, iFrames & Nested iFrames

## Frames

A frame is a separate browsing context inside a webpage. Selenium must switch to the frame before interacting with elements inside it.

## iFrames

An iframe (`<iframe>`) is an HTML element used to embed another webpage or document inside the current webpage.

Selenium treats an iframe as a separate browsing context, so you must switch to it before interacting with elements inside it.

## Switching to a Frame

### Using WebElement

```java
driver.switchTo().frame(frame);
```

### Using Index

```java
driver.switchTo().frame(0);
```

The index is based on the frames/iframes available in the **current frame context**.

## Switching Back to the Main Page

```java
driver.switchTo().defaultContent();
```

`defaultContent()` switches back to the main page.

## Nested iFrames

A frame can contain another iframe.

To interact with an element inside a nested iframe:

1. Switch to the outer frame.
2. Switch to the inner iframe.
3. Interact with the element.

```java
driver.switchTo().frame(frame3);

// Inner iframe
driver.switchTo().frame(0);
```

### Frame Context

The frame index is relative to the **current frame context**.

After switching to Frame 3:

```java
driver.switchTo().frame(0);
```

refers to the first iframe available inside Frame 3, not the first frame on the main page.

## Debugging Frame Issues

When frame switching fails, check:

- Current frame context
- Frame/iframe count
- `src`, `id`, or `name` attributes
- Whether the frame exists in the current DOM
- Whether the selected frame is actually the required frame

Use temporary diagnostic code when necessary to determine what Selenium actually sees.

## Dropdowns

1. Select Dropdown
2. Custom / Bootstrap Dropdown
3. Hidden / Dynamic Dropdown

## 1. Select Dropdown

A **Select dropdown** uses the HTML `<select>` tag.

Use Selenium's `Select` class:

```java
WebElement element = driver.findElement(By.xpath("select_xpath"));
Select dropdown = new Select(element);
```

### Select an option

```java
dropdown.selectByVisibleText("India");
dropdown.selectByValue("japan");
dropdown.selectByIndex(3);
```

**Index starts from `0`.**

### Get and count options

```java
List<WebElement> options = dropdown.getOptions();
System.out.println(options.size());
```

### Print options

```java
for (WebElement option : options) {
    System.out.println(option.getText());
}
```

### Get selected option

```java
System.out.println(dropdown.getFirstSelectedOption().getText());
```

---

## 2. Custom / Bootstrap Dropdown

If the dropdown is **not** a `<select>` element, do **not** use `Select`.

Typical approach:

```text
Click dropdown
     ↓
Locate option
     ↓
Click option
```

Example:

```java
driver.findElement(By.xpath("dropdown_xpath")).click();

WebElement option = driver.findElement(
    By.xpath("option_xpath")
);

option.click();
```

---

## 3. Hidden / Dynamic Dropdown

Some custom dropdowns display their options only after the dropdown is opened.

```text
Open dropdown
      ↓
Options appear dynamically
      ↓
Locate option
      ↓
Click option
```

### Important

- These dropdowns may not show the option elements when the dropdown is closed.
- Open the dropdown first, then inspect/locate the option.
- Tools such as browser DevTools or SelectorsHub Debugger can help inspect temporary elements.
- This is mainly an inspection/debugging technique, not a different Selenium API.

## Selecting Multiple Options – Custom Dropdown

If the custom dropdown closes after each selection, reopen it for each target.

```java
String[] targetOptions = {"Option1", "Option2"};

for (String targetOption : targetOptions) {

    driver.findElement(By.xpath("dropdown_xpath")).click();

    driver.findElement(By.xpath(
        "option_xpath_for_" + targetOption
    )).click();
}
```

`targetOption` contains **one array value at a time**.

---

## Select vs Custom Dropdown

| Type                        | Selenium approach         |
| --------------------------- | ------------------------- |
| `<select>` dropdown         | `Select` class            |
| Custom `div/ul/li` dropdown | Locate and click elements |

### Key rule

**Inspect the DOM first.**

```text
Is it <select>?
   ├─ Yes → Select class
   └─ No  → Custom dropdown → click + locate option + click
```

## Interview Quick Revision

- `selectByVisibleText()` → select by displayed text
- `selectByValue()` → select by `value` attribute
- `selectByIndex()` → select by index
- `getOptions()` → get all options
- `getFirstSelectedOption()` → get selected option
- `Select` class works with HTML `<select>` elements
- Custom dropdowns require normal element locators/clicks

## Auto-Suggest Dropdown

An **Auto-Suggest Dropdown** displays suggestions dynamically based on the text entered by the user.

Typical flow:

```text
Enter text
    ↓
Suggestions appear dynamically
    ↓
Capture all suggestions
    ↓
Loop through suggestions
    ↓
Match required text
    ↓
Click the matching suggestion
```

### Key points

- Auto-suggest results are **dynamic**.
- Use `findElements()` when multiple suggestions need to be captured.
- Store them in `List<WebElement>`.
- Use a loop to check each suggestion.
- `getText()` → reads the suggestion text.
- `click()` → selects the required suggestion.
- `break` → stops after finding the required suggestion.

## Static Web Table

A **Static Web Table** contains table data that is already present on the page.

### Basic structure

```text
<table> → table
<tr>    → row
<th>    → header
<td>    → data cell
```

### Rows and columns

```text
findElements(...).size()
```

- `<tr>` → count rows
- `<th>` → count columns

Use a table-specific XPath when the page contains multiple tables.

### Specific cell

```xpath
//table[@name='BookTable']//tr[row]//td[column]
```

Example:

```xpath
//table[@name='BookTable']//tr[5]//td[1]
```

→ 5th row, 1st column

### Complete table

Use **nested loops**:

```text
Outer loop → rows
Inner loop → columns
```

The row and column numbers are used to build the XPath dynamically.

### Conditional data

```text
Read Author
   ↓
Check Author = "Mukesh"
   ↓
If yes → read BookName from same row
```

This is **conditional table data retrieval**.

### Calculating table values

```text
Read value
   ↓
Convert String → int
   ↓
Perform calculation
```

```java
Integer.parseInt(value);
```

---

## 3. Column-wise Data

To get all values from one column:

```xpath
//table[@name='BookTable']//tr/td[1]
```

→ all BookNames

```xpath
//table[@name='BookTable']//tr/td[2]   → Authors
//table[@name='BookTable']//tr/td[3]   → Subjects
//table[@name='BookTable']//tr/td[4]   → Prices
```

```text
findElements()
    ↓
List<WebElement>
    ↓
loop
```

### Column-wise vs Complete Table

```text
One column  → single loop
Whole table → nested loops
```

---

## 4. Important Table XPath Patterns

```xpath
//table[@name='BookTable']//tr
```

→ all rows

```xpath
//table[@name='BookTable']//th
```

→ all headers

```xpath
//table[@name='BookTable']//tr[1]//th
```

→ headers from first row

```xpath
//table[@name='BookTable']//tr[5]//td[1]
```

→ specific cell

```xpath
//table[@name='BookTable']//tr/td[1]
```

→ all cells from first column

---

## 5. Interview Quick Revision

- `<tr>` → row
- `<th>` → header
- `<td>` → data cell
- `findElement()` → one element
- `findElements()` → multiple elements
- `.size()` → number of elements
- Specific cell → row + column XPath
- One column → single loop
- Complete table → nested loops
- Outer loop → rows
- Inner loop → columns
- Conditional retrieval → check one column, retrieve data from same row
- `getText()` → read cell value
- `Integer.parseInt()` → convert `String` to `int`
