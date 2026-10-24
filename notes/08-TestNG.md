# TestNG

TestNG stands for Test New Generation.

It is a Java-based testing framework.

## Advantages of TestNG

1. Test cases and test suites
2. Grouping of test cases
3. Prioritization of test cases
4. Parameterization
5. Parallel testing
6. Reports

## TestNG Configuration

1. Add the TestNG dependency to the `pom.xml` file.
2. Use the `@Test` annotation to identify test methods.

## @Test Annotation

- `@Test` is used to mark a method as a TestNG test method.
- TestNG executes methods annotated with `@Test`.

## Priority Rules

1. TestNG executes test methods based on its default ordering when priorities are not specified.
2. `@Test(priority = num)` controls the execution order of test methods.
3. Lower priority numbers execute before higher priority numbers.
4. Priorities do not need to be consecutive numbers.
5. If priority is not specified, the default priority is `0`.
6. If multiple methods have the same priority, TestNG generally executes them alphabetically by method name.
7. Negative priority values are allowed.
8. Only methods annotated with `@Test` are executed as test methods.

## Executing TestNG Tests

TestNG tests can be executed in two ways:

1. Run the test class directly from the IDE.
2. Execute tests using the `testng.xml` file.

## TestNG XML File

There are two ways to create a TestNG XML file:

1. Generate it automatically using the IDE.
2. Create it manually.

### Two purposes of testng.xml

1. Execute a group of test classes as one test suite.
2. Generate TestNG reports when the suite is executed.


# TestNG Annotations and Assertions

## TestNG Annotations

TestNG annotations control when setup methods, test methods, and cleanup
methods execute.


| Annotation      | Purpose                                             |
|-----------------|-----------------------------------------------------|
| `@BeforeSuite`  | Runs once before the test suite starts.             |
| `@AfterSuite`   | Runs once after the test suite finishes.            |
| `@BeforeTest`   | Runs before the tests in an XML `<test>` section.   |
| `@AfterTest`    | Runs after the tests in an XML `<test>` section.    |
| `@BeforeClass`  | Runs once before the first test method in a class.  |
| `@AfterClass`   | Runs once after all test methods in a class finish. |
| `@BeforeMethod` | Runs before each `@Test` method.                    |
| `@AfterMethod`  | Runs after each `@Test` method.                     |
| `@Test`         | Marks a method as a test method.                    |


### Important points

-   `@BeforeSuite` and `@AfterSuite` run once per suite.
-   `@BeforeTest` and `@AfterTest` run for each applicable XML `<test>`
    section.
-   `@BeforeClass` and `@AfterClass` run once per class.
-   `@BeforeMethod` and `@AfterMethod` run around each test method. With
    two `@Test` methods, they normally run twice each.
-   `priority` can be used to specify test method order, for example
    `@Test(priority=1)`. Without explicit ordering, do not assume test
    methods will run in the order you expect.
-   The order of methods in the Java source file does not determine
    lifecycle execution; TestNG manages it using annotations.
-   Lifecycle methods commonly use `void` because they do not return a
    value. `public` and `static` are not required for the examples in
    this topic.

## TestNG XML

A TestNG XML file specifies which classes TestNG should run.

-   In this project, XML files are kept in the project root alongside
    `pom.xml`.
-   Use the fully qualified class name, including the package, in the
    XML.
-   One XML `<test>` section can contain multiple Java classes.
-   Applicable `@BeforeTest` and `@AfterTest` methods run for each XML
    `<test>` section.
-   A separate XML file is useful when you want to run a specific set of
    classes without running unrelated tests.

## TestNG Assertions

Assertions validate whether an actual result matches an expected result.
A failed assertion causes TestNG to mark the test as **FAILED**.


### Common hard assertions

| Assertion                                  | Purpose                                  |
|--------------------------------------------|------------------------------------------|
| `Assert.assertEquals(actual, expected)`    | Checks whether two values are equal.     |
| `Assert.assertNotEquals(actual, expected)` | Checks whether two values are different. |
| `Assert.assertTrue(condition)`             | Passes if the condition is true.         |
| `Assert.assertFalse(condition)`            | Passes if the condition is false.        |
| `Assert.assertNull(value)`                 | Passes if the value is `null`.           |
| `Assert.assertNotNull(value)`              | Passes if the value is not `null`.       |
| `Assert.fail()`                            | Explicitly fails the test.               |


### Assertion parameter order

For TestNG's `Assert.assertEquals()`, use **actual first, expected
second**:

`Assert.assertEquals(actualTitle, expectedTitle);`

If the values differ, TestNG reports the mismatch and marks the test as
failed.

### If-else vs. assertions

-   **`if-else`:** Checks a condition and can print a message such as
    "test failed." Printing a message alone does not make TestNG mark
    the test as failed.
-   **Assertion:** Validates the result and reports a failure to TestNG
    if the condition is not met.

It is also possible to put an assertion inside an `if-else` branch, such
as `Assert.assertTrue(false)`, but a direct assertion is usually simpler
when validating an expected result.

## Hard Assertions

A hard assertion stops the current test method at the point where an
assertion fails. Statements after that failed assertion in the same test
method are skipped.

Applicable cleanup methods, such as `@AfterMethod`, can still execute
after a hard assertion failure.

## Soft Assertions

A soft assertion records a failed check but allows the test method to
continue executing. Use TestNG's `SoftAssert` class.

Important points:

-   Create a `SoftAssert` object before using its assertion methods.
-   Continue running the remaining statements after a soft assertion
    fails.
-   Call `assertAll()` at the end of the test method to report the
    accumulated assertion failures.
-   If `assertAll()` is omitted, the recorded soft assertion failures
    may not cause the test to be reported as failed.

    
## Hard vs Soft Assertions

| Hard assertion                                 | Soft assertion                                      |
|------------------------------------------------|-----------------------------------------------------|
| Stops the test method when an assertion fails. | Continues the test method after an assertion fails. |
| Uses `Assert` methods.                         | Uses a `SoftAssert` object.                         |
| Does not require `assertAll()`.                | Requires `assertAll()` to report failures.          |
