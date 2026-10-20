TestNG - Test New Generation

java based unit testing tool

Advantages:

1. Test cases & test suites
2. Grouping of test cases
3. Prioritize
4. Parameterization
5. Parallel testing
6. Reports

// mvn -Dtest=TestNGBasics test

@Test - annotation

# Priority Rules

1. TestNG execute test methods based on alphabetical order.
2. @Test(priority=num) - controls the order of the execution.
3. Once you provide priority to the test methods, then order of methods is not considered.
4. Priorities can be random numbers (no need to have consecutive numbers)
5. If you do not provide priority, then default value is zero.
6. If priorities are same, then again execute methods in alphabetical order.
7. Negative values are also allowed in priority.
8. TestNG execute test methods only if they are having @Test annotation.

execute test cases using testing xml file

## test xml file

1. generate automatically
2. manually
