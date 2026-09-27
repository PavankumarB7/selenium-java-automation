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
