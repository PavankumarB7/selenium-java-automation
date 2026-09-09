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
