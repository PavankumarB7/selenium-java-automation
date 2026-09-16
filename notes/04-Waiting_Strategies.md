# Waiting Strategies

## Synchronization

Synchronization is used to make Selenium wait until the application is
ready for the next action.

### Wait Types / Synchronization Approaches

1.  `Thread.sleep()`
2.  Implicit Wait
3.  Explicit Wait
    - `WebDriverWait`
    - Fluent Wait

> Fluent Wait is another flavor of Explicit Wait.

> `Thread.sleep()` is a Java method, not a Selenium wait command.

---

## `Thread.sleep()`

Pauses execution for a fixed amount of time.

```java
Thread.sleep(5000);
```

### Advantage

- Easy to use.

### Disadvantages

- Fixed wait time, even if the element is ready earlier.
- If the time is insufficient, the element may still not be ready.
- Multiple `Thread.sleep()` calls can slow down the script.

---

## Implicit Wait

Applied globally to element-location operations for a WebDriver
instance.

```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

### Advantages

- Single statement.
- Applies globally.
- Does not necessarily wait for the full timeout if the element is
  found earlier.
- Easy to use.

### Disadvantage

- If the element cannot be located within the timeout,
  `NoSuchElementException` is thrown.

---

## Explicit Wait

Condition-based wait that waits until a specific condition is satisfied
or the timeout is reached.

Points

1. Finding the element is included for some conditions, such as
   visibilityOfElementLocated() and elementToBeClickable().

2. It waits for the specified condition to be satisfied or until the
   timeout is reached.

3. Different elements or conditions may require separate wait
   statements.

### Declaration

```java
WebDriverWait myWait =
        new WebDriverWait(driver, Duration.ofSeconds(10));
```

### Example

```java
WebElement username = myWait.until(
        ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Username']")
        )
);
```

### Common Expected Conditions

- `visibilityOfElementLocated()`
- `elementToBeClickable()`
- `presenceOfElementLocated()`
- `alertIsPresent()`
- `titleContains()`
- `titleIs()`

---

## Fluent Wait

Fluent Wait is another flavor of Explicit Wait.

It allows configuration of:

- Maximum timeout
- Polling interval
- Exceptions to ignore

### Example

```java
Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofSeconds(5))
        .ignoring(NoSuchElementException.class);
```

### Methods

- `withTimeout()` → maximum wait time
- `pollingEvery()` → frequency of checking
- `ignoring()` → exceptions to ignore while waiting

---

## NoSuchElementException

Thrown when Selenium cannot locate the requested element.

```java
import org.openqa.selenium.NoSuchElementException;
```

An incorrect locator can also result in `NoSuchElementException`.

---

## Quick Comparison

| Wait / Approach  | Purpose                                                  |
| ---------------- | -------------------------------------------------------- |
| `Thread.sleep()` | Fixed-time Java pause                                    |
| Implicit Wait    | Global element-location wait                             |
| Explicit Wait    | Wait for a specific condition                            |
| Fluent Wait      | Explicit Wait with custom polling and exception handling |
