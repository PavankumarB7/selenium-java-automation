## WebDriver Methods

1. Get Methods
2. Conditional Methods
3. Browser Methods
4. Navigational Methods
5. Wait Methods

## Get Methods

We can access these methods through the WebDriver instance.

- `get(url)` - opens the URL in the browser

- `getTitle()` - returns the title of the current page

- `getCurrentUrl()` - returns the URL of the current page

- `getPageSource()` - returns the page source

- `getWindowHandle()` - returns the unique ID (handle) of the current browser window/tab

- `getWindowHandles()` - returns the unique IDs (handles) of all open browser windows/tabs

## Conditional Methods

We can access these methods through a WebElement.

These methods return a boolean value (`true`/`false`).

1. `isDisplayed()` - checks whether the element is displayed/visible

2. `isEnabled()` - checks whether the element is enabled or disabled

3. `isSelected()` - checks whether the element is selected or not

## Browser Methods

- `close()` - closes the current browser window/tab

- `quit()` - closes all browser windows/tabs and ends the WebDriver session

## Navigational Methods

Navigation methods are used to navigate between pages in the browser.

## `navigate().to()`

Opens a URL in the browser.

```java
driver.navigate().to("https://example.com");
```

## `navigate().back()`

Navigates back to the previous page.

```java
driver.navigate().back();
```

## `navigate().forward()`

Navigates forward to the next page.

```java
driver.navigate().forward();
```

## `navigate().refresh()`

Refreshes the current page.

```java
driver.navigate().refresh();
```

### `get()` vs `navigate().to()`

Both methods can be used to open a URL.

- `driver.get(url)` → opens/navigates to the specified URL.
- `driver.navigate().to(url)` → also opens/navigates to the specified URL.

`navigate()` additionally provides:

- `back()`
- `forward()`
- `refresh()`

> **Interview Point:** `get()` and `navigate().to()` can both navigate directly to a URL. The main practical difference is that the `navigate()` API also provides browser navigation operations such as back, forward, and refresh.

> **Note:** `navigate().to()` can also accept a `java.net.URL` object, but in normal Selenium automation, URLs are commonly passed as `String` values.

## Handling Browser Windows / Tabs

Selenium uses window handles to identify browser windows and tabs.

### `getWindowHandle()`

Returns the unique handle of the current browser window/tab.

### `getWindowHandles()`

Returns the unique handles of all open browser windows/tabs in the current WebDriver session.

### Parent and Child Windows

- **Parent window** → usually the original window/tab
- **Child window** → usually the newly opened window/tab
- Use `switchTo().window()` to switch between them.

### Approaches to Handle Windows/Tabs

1. **Using List and Window Handle Index**
2. **Using Window Title**

> The List approach is useful when the number/order of windows is known.  
> The title-based approach identifies the required window based on its title.

### Closing a Specific Window

Switch to the required window/tab and use `close()`.

> `close()` closes the currently focused window/tab.

### Important Methods

| Method                | Purpose                                           |
| --------------------- | ------------------------------------------------- |
| `getWindowHandle()`   | Gets the current window/tab handle                |
| `getWindowHandles()`  | Gets handles of all open windows/tabs             |
| `switchTo().window()` | Switches to a specific window/tab                 |
| `close()`             | Closes the currently focused window/tab           |
| `quit()`              | Closes all windows and ends the WebDriver session |
