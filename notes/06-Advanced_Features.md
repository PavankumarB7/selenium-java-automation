# Advanced Features

## Alerts

Alerts are JavaScript popups displayed by a web page.

Alerts are not normal WebElements, so they cannot be located using `findElement()`.

Selenium provides the `Alert` interface to interact with alerts.

### Types of Alerts

1. Normal Alert
   - Contains an OK button.
   - `getText()` retrieves the alert message.
   - `accept()` clicks OK.

2. Confirmation Alert
   - Contains OK and Cancel buttons.
   - `accept()` clicks OK.
   - `dismiss()` clicks Cancel.

3. Prompt Alert
   - Contains an input field.
   - `sendKeys()` enters text.
   - `accept()` accepts the prompt.

### Handling Alerts Using Explicit Wait

`ExpectedConditions.alertIsPresent()` can be used with `WebDriverWait` to wait until an alert is present.

It returns the `Alert` object when the alert becomes available.

## Authenticated Popups

For HTTP Basic Authentication, credentials can be included in the URL.

### Syntax

`https://username:password@website.com`

The browser uses the username and password from the URL to authenticate with the protected page.
