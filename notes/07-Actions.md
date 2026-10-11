# Mouse Actions

Mouse hover - moveToElement(element)
right click - contextClick(element)
double click - doubleClick(element)
drag and drop - dragAndDrop(source, target)

# Actions

- pre defined class in selenium

build() - creates an Action sequence from the actions defined in the builder.
perform() - executes the action sequence. It can also be called directly without build() for ordinary action chains.

## getText() vs getAttribute()

- getText() - returns the visible text of an element.
- getAttribute("attributeName") — retrieves an attribute's value, such as the value attribute of an input field.

getText() does not necessarily return all inner text in the DOM; hidden text may not be returned.

## Actions vs Action

- Actions: A Selenium class used to perform mouse and keyboard actions.
- Action: An interface used to represent a sequence of actions.

# Keyboard Actions

- `keyDown(key)` - presses and holds a key.
- `keyUp(key)` - releases a key.
- `sendKeys()` - types text or sends a key.
- `perform()` - executes the action.

**Examples:**

- Ctrl + A - selects all text.
- Ctrl + C - copies selected text.
- Ctrl + V - pastes copied text.
- Tab - moves focus to the next focusable element.

Keyboard actions operate on the currently focused element or selection.

# Sliders

- `getLocation()` - returns the element's current location as X and Y coordinates.
- `dragAndDropBy(element, xOffset, yOffset)` - moves an element by the specified horizontal and vertical offsets.

**X and Y offsets:**

- Positive X - move right.
- Negative X - move left.
- Positive Y - move down.
- Negative Y - move up.
- `0` - request no movement on that axis.

For a horizontal slider, use `0` for the Y offset.

**Important:** `getLocation()` returns the current position, but `dragAndDropBy()` takes movement offsets. The Y coordinate returned by `getLocation()` should not be used as the Y offset just to keep a horizontal slider on the same track. Check the slider's displayed value as well as its location.

# Tabs and Windows

- `getWindowHandle()` - returns the handle of the current tab/window.
- `getWindowHandles()` - returns a `Set<String>` containing handles for all open tabs/windows.
- `switchTo().window(handle)` - switches WebDriver's focus to the specified tab/window.
- `close()` — closes the current tab/window.
- `quit()` — closes all browser windows opened by that WebDriver session and ends the session.

**Note:** `getWindowHandles()` returns a `Set`, which does not guarantee tab order. Converting it to a list does not guarantee that index `0` is always the original tab or index `1` is always the new tab. For more reliable automation, compare the handles before and after opening a new tab to identify the new handle.

# Selenium 4 — Opening a New Tab or Window

- `WindowType.TAB` - opens a new tab and switches WebDriver's focus to it.
- `WindowType.WINDOW` - opens a new browser window and switches WebDriver's focus to it.

Use `driver.get(url)` to navigate the newly opened tab or window.
