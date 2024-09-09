# CoreJavaNSeleniumForMe

## Xpath

Table summarizing the important XPath syntax with their formulas:

| XPath Syntax                                              | Description                                                  | Example                                                 |
| ----------------------------------------------            | ------------------------------------------------------------ | ------------------------------------------------------- |
| `//tagname`                                               | Selects all nodes with the name `tagname` anywhere in the document. | `//div` selects all `<div>` elements.                   |
| `//*`                                                     | Selects all elements in the document.                        | `//*` selects all elements in the document.             |
| `/tagname`                                                | Selects the root node with the name `tagname`.              | `/html` selects the root `<html>` element.             |
| `/tagname/subtagname`                                     | Selects a child node `subtagname` of the `tagname` node.    | `/div/span` selects all `<span>` elements inside `<div>` |
| `//tagname[@attribute='value']`                           | Selects all nodes with the name `tagname` that have an attribute `attribute` with the value `value`. | `//input[@type='text']` selects all text `<input>` elements. |
| `//tagname[position()=n]`                                 | Selects the `n`th `tagname` element.                        | `//tr[position()=3]` selects the third `<tr>` element.  |
| `//tagname[last()]`                                       | Selects the last `tagname` element.                         | `//p[last()]` selects the last `<p>` element.          |
| `//tagname[contains(@attribute, 'value')]`                | Selects all nodes with the name `tagname` where the attribute `attribute` contains the substring `value`. | `//a[contains(@href, 'example')]` selects all `<a>` elements with `href` containing "example". |
| `//tagname[starts-with(@attribute, 'value')]`             | Selects all nodes with the name `tagname` where the attribute `attribute` starts with the substring `value`. | `//img[starts-with(@src, 'images/')]` selects all `<img>` elements with `src` starting with "images/". |
| `//tagname[text()='value']`                               | Selects all nodes with the name `tagname` that have the exact text content `value`. | `//h1[text()='Welcome']` selects the `<h1>` with text "Welcome". |
| `//tagname[contains(text(), 'value')]`                    | Selects all nodes with the name `tagname` that contain the substring `value` in their text content. | `//p[contains(text(), 'Lorem ipsum')]` selects all `<p>` elements containing "Lorem ipsum" in their text. |
| `//tagname[@attribute='value1' or @attribute='value2']`   | Selects all nodes with the name `tagname` where the attribute `attribute` is either `value1` or `value2`. | `//input[@type='text' or @type='password']` selects all `<input>` elements with type "text" or "password". |
| `//tagname[@attribute='value1' and @attribute2='value2']` | Selects all nodes with the name `tagname` where `attribute` is `value1` and `attribute2` is `value2`. | `//div[@class='container' and @id='main']` selects all `<div>` elements with class "container" and id "main". |
| `//tagname/..`                                            | Selects the parent of the `tagname` element.                 | `//p/..` selects the parent of all `<p>` elements.      |
| `//tagname/following-sibling::siblingname`                | Selects all sibling nodes that come after the `tagname` node. | `//h2/following-sibling::p` selects all `<p>` sibling elements that come after `<h2>` elements. |
| `//tagname/preceding-sibling::siblingname`                | Selects all sibling nodes that come before the `tagname` node. | `//p/preceding-sibling::h2` selects all `<h2>` sibling elements that come before `<p>` elements. |
| `//tagname/parent::parentname`                            | Selects the parent node with the name `parentname` of the `tagname` node. | `//li/parent::ul` selects the `<ul>` parent element of all `<li>` elements. |
| `//tagname/ancestor::ancestorname`                        | Selects all ancestor nodes with the name `ancestorname` of the `tagname` node. | `//span/ancestor::div` selects all `<div>` ancestor elements of all `<span>` elements. |

## Collections

The high-level diagram with interfaces represented as ovals and classes represented as rectangles:

```
                          +-------------+
                          |  Iterable   |
                          +-------------+
                                 |
                                 |
                           +-------------+
                           | Collection  |
                           +-------------+
      /         |          |           \            \
     /          |          |            \            \
+------+   +-----------+   +----+   +-----------+   +---------+
| List |   |  Queue    |   |Set |   | Deque     |   |  Map    |
+------+   +-----------+   +----+   +-----------+   +---------+
   |            |           |           |                 |
   |            |           |           |                 |
   |            |           |           |                 |
+----------+   +-------------+  +-----------+  +-----------------+
|ArrayList |   | LinkedList  |  |  HashSet  |  |  ArrayDeque     |
+----------+   +-------------+  +-----------+  +-----------------+
|  Vector  |   | PriorityQueue|  |LinkedHashSet|  | LinkedList   |
+----------+   +-------------+  +-------------+  +-----------------+
|  Stack   |
+----------+
```

### Explanation

- **Ovals**:
  - **Iterable**: The root interface for all collection classes. It provides the ability to iterate over elements using an iterator.
  - **Collection**: Extends `Iterable` and is the root interface for all collections, including lists, sets, and queues. It represents a group of objects.
  - **List**: Extends `Collection` and represents an ordered collection (sequence) that allows duplicates.
  - **Set**: Extends `Collection` and represents a collection that does not allow duplicate elements.
  - **Queue**: Extends `Collection` and represents a collection designed for holding elements prior to processing. Typically orders elements in a FIFO (first-in-first-out) manner.
  - **Deque**: Extends `Queue` and represents a double-ended queue that allows element insertion and removal at both ends.
  - **Map**: Not part of `Collection` but closely related. Represents a collection of key-value pairs.

- **Rectangles**:
  - **ArrayList**: Resizable array implementation.
  - **LinkedList**: Doubly-linked list implementation.
  - **Vector**: Synchronized, resizable array implementation.
  - **Stack**: Subclass of `Vector` that represents a last-in-first-out (LIFO) stack of objects.
  - **HashSet**: Implements a set backed by a hash table (actually a `HashMap` instance).
  - **LinkedHashSet**: Extends `HashSet` and maintains a linked list of the entries in the set, in the order in which they were inserted.
  - **PriorityQueue**: A priority queue based on a priority heap.
  - **ArrayDeque**: Resizable array implementation of the `Deque` interface.
  - **HashMap**: Implementation based on a hash table.
  - **LinkedHashMap**: Extends `HashMap` and maintains a doubly-linked list of its entries.

## WebTable Scrapping

The difference between the two sets of code you provided lies in how the XPath expressions are interpreted in relation to the context element (`firstTable`):

### Without the Dot (Context-Insensitive)

```java
WebElement firstTable = driver.findElement(By.cssSelector("#table1"));
List<WebElement> rows = firstTable.findElements(By.xpath("//tbody/tr"));
```

- **XPath Expression**: `//tbody/tr`
- **Interpretation**: This XPath expression starts from the root of the document, not from the `firstTable` element. It will search for all `tbody/tr` elements in the entire document, not just within `firstTable`.

### With the Dot (Context-Sensitive)

```java
WebElement firstTable = driver.findElement(By.cssSelector("#table1"));
List<WebElement> rows = firstTable.findElements(By.xpath(".//tbody/tr"));
```

- **XPath Expression**: `.//tbody/tr`
- **Interpretation**: This XPath expression starts from the context of the `firstTable` element. The `.` indicates the current node (context node), so it will search for all `tbody/tr` elements that are descendants of `firstTable`.

### Key Differences

1. **Scope of Search**:
   - **Without Dot (`//tbody/tr`)**: Searches the entire document from the root, ignoring the context element (`firstTable`).
   - **With Dot (`.//tbody/tr`)**: Searches only within the `firstTable` element, respecting the context element.

2. **Performance**:
   - **Without Dot**: Potentially slower if the document is large and there are many `tbody/tr` elements, since it searches the entire DOM.
   - **With Dot**: More efficient as it limits the search to the subtree under `firstTable`.

3. **Accuracy**:
   - **Without Dot**: May return elements that are outside the intended context (`firstTable`), leading to incorrect or unexpected results.
   - **With Dot**: Ensures that only elements within `firstTable` are returned, providing accurate and expected results.

### Example for Clarification

Consider the following HTML structure:

```html
<html>
  <body>
    <table id="table1">
      <tbody>
        <tr><td>Row 1, Table 1</td></tr>
        <tr><td>Row 2, Table 1</td></tr>
      </tbody>
    </table>
    <table id="table2">
      <tbody>
        <tr><td>Row 1, Table 2</td></tr>
        <tr><td>Row 2, Table 2</td></tr>
      </tbody>
    </table>
  </body>
</html>
```

- **Without Dot (`//tbody/tr`)**: This will find all `tr` elements within `tbody` elements in the entire document, so it will find 4 `tr` elements (2 from `table1` and 2 from `table2`).
- **With Dot (`.//tbody/tr`)**: This will find only `tr` elements within the `tbody` of `table1`, so it will find 2 `tr` elements (both from `table1`).

### Conclusion

Using the dot (`.`) in the XPath expression is crucial when you want to restrict your search to within a specific context element. In this case, to ensure you're only finding rows (`tr` elements) within `#table1`, you should use the context-sensitive XPath:

```java
List<WebElement> rows = firstTable.findElements(By.xpath(".//tbody/tr"));
```

## Waits

### Implicit/Explicit and Fluent Wait

<https://www.selenium.dev/documentation/webdriver/waits/>

**Implicit Wait**: A global wait applied to all element interactions, waiting for a set time before throwing an exception.  
**Explicit Wait**: Waits for a specific condition (e.g., clickable element) to be met before proceeding.  
**Fluent Wait**: A customizable explicit wait that checks for a condition at intervals, ignoring specific exceptions during polling.  

```java
// implicitwat
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

// explicit wait
WebElement successMessage = new WebDriverWait(driver, Duration.ofSeconds(18)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.bg-success")));

//fluentwait
Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

WebElement successMessage = wait.until(driver -> driver.findElement(By.cssSelector("p.bg-success")));

```

## JavaScript Execution

 The JavaScript Executor in Selenium WebDriver allows you to execute JavaScript code within the context of the browser. This can be particularly useful for performing actions that are not directly supported by Selenium WebDriver or for manipulating elements in ways that WebDriver does not natively support.

### Explanation of the Syntax

```java
js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollableDiv);
```

- **`js`**: This is the instance of `JavascriptExecutor`. It's cast from the `WebDriver` instance to enable JavaScript execution.

- **`executeScript`**: This method of `JavascriptExecutor` is used to execute JavaScript code in the context of the currently loaded page.

- **`"arguments[0].scrollTop = arguments[0].scrollHeight;"`**: This is the JavaScript code to be executed. Let's break it down further:
  - **`arguments[0]`**: In the context of `executeScript`, `arguments` is an array of objects passed to the script. `arguments[0]` refers to the first argument passed to the script (in this case, `scrollableDiv`).
  - **`scrollTop`**: This property of a scrollable element indicates the number of pixels that the content of an element is scrolled vertically.
  - **`scrollHeight`**: This property of an element returns the entire height of an element in pixels, including content not visible on the screen due to overflow.
  - **Assignment (`=`)**: The code assigns the `scrollHeight` value to `scrollTop`, effectively scrolling the element to the bottom.

- **`scrollableDiv`**: This is the WebElement passed as an argument to the JavaScript code. It corresponds to `arguments[0]` in the JavaScript code.

### Complete Breakdown

1. **JavaScript Code**: `"arguments[0].scrollTop = arguments[0].scrollHeight;"` is the JavaScript code being executed.
   - This code sets the `scrollTop` property of the first argument (which is the `scrollableDiv` element) to its `scrollHeight`, thereby scrolling it to the bottom.

2. **Arguments**: `scrollableDiv` is passed to the `executeScript` method as an argument.
   - In the JavaScript code, `arguments[0]` refers to this `scrollableDiv` element.

### Execution Flow

- The `executeScript` method runs the JavaScript code with the `scrollableDiv` element.
- The JavaScript code `arguments[0].scrollTop = arguments[0].scrollHeight;` sets the scroll position of `scrollableDiv` to its maximum scroll height.
- This effectively scrolls the `scrollableDiv` element to the bottom.

### Summary

In summary, `js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollableDiv);` uses JavaScript to scroll the specified element (`scrollableDiv`) to the bottom by setting its `scrollTop` property to its `scrollHeight`.  

## Download a file

To download a file to a specific folder in Selenium using ChromeDriver, you need to configure ChromeOptions to specify the download directory and handle download settings. Here is a summary of the required settings:

### Steps to Configure ChromeDriver for File Download

1. **Create ChromeOptions**:
   - Use `ChromeOptions` to set preferences for downloading files.

2. **Set Preferences in ChromeOptions**:
   - `download.default_directory`: Specify the directory where files should be downloaded.
   - `download.prompt_for_download`: Set to `false` to disable the download prompt.

3. **Initialize WebDriver with ChromeOptions**:
   - Create a new instance of `ChromeDriver` with the configured `ChromeOptions`.

4. **Ensure the Download Directory Exists**:
   - Check if the specified download directory exists and create it if it doesn't.


### Example

1. **ChromeOptions**:
   ```java
   ChromeOptions options = new ChromeOptions();
   Map<String, Object> prefs = new HashMap<>();
   prefs.put("download.default_directory", "path/to/download/directory");
   prefs.put("download.prompt_for_download", "false");
   options.setExperimentalOption("prefs", prefs);
   ```

2. **Initialize WebDriver**:

   ```java
   WebDriver driver = new ChromeDriver(options);
   ```

3. **Ensure Directory Exists**:

   ```java
   // Ensure download directory exists
        Path downloadDir = Paths.get(downloadFilePath);
        try {
            if (!Files.exists(downloadDir)) {
                Files.createDirectories(downloadDir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   ```

This setup ensures that downloaded files are saved to the specified directory within your project, leveraging the capabilities of Selenium and ChromeOptions.

## TESTNG

### Annotations

Here is the scope of each TestNG annotation:

- **@BeforeSuite**: Runs once before all tests in the suite.
- **@AfterSuite**: Runs once after all tests in the suite.
- **@BeforeTest**: Runs once before any test methods in the `<test>` tag.
- **@AfterTest**: Runs once after all test methods in the `<test>` tag.
- **@BeforeClass**: Runs once before the first test method in the current class.
- **@AfterClass**: Runs once after all test methods in the current class.
- **@BeforeMethod**: Runs before each test method in that specific class
- **@AfterMethod**: Runs after each test method  in that specific class
- **@Test**: Represents a test method.

## Attributes with Annotations

Common helper attributes used with TestNG annotations:

- **`dependsOnMethods`**: Specifies dependencies between test methods, ensuring one method runs only after specified methods have completed.

- **`priority`**: Controls the execution order of test methods within a class, with lower values indicating higher priority.

- **`groups`**: Assigns test methods to one or more groups, allowing selective execution of tests based on group categorization.

- **`enabled`**: Enables or disables a test method. Disabled methods are skipped during test execution.

- **`dataProvider`**: Links a test method to a data provider method supplying data for parameterized tests, enhancing test coverage with varied inputs.

These attributes provide essential functionality for managing dependencies, execution order, grouping tests, enabling/disabling tests, and parameterizing tests with external data, ensuring flexibility and control in TestNG test suites.

```java
@Test
public void testA() {
    // Test logic
}

@Test(dependsOnMethods = "testA", priority = 2, groups = {"smoke","regression"},enabled = true)
public void testB() {
    // Test logic that depends on testA
}

@Test(dataProvider = "data-provider", dependsOnMethods = "loginTest")
public void testWithDataProvider(String username, String password) {
    // Test logic using data provided by "data-provider" and depends on loginTest
}

@DataProvider(name = "data-provider")
public Object[][] dataProviderMethod() {
    return new Object[][] {
        {"user1", "password1"},
        {"user2", "password2"}
    };
}
```
The `@FindBy` annotation in Selenium does not support an "or" condition directly. However, you can achieve similar functionality using the `@FindAll` annotation, which allows you to specify multiple criteria, and the element will be located if any of the specified conditions match.

### Using `@FindAll`

`@FindAll` to specify multiple IDs:

```java
@FindAll({
    @FindBy(id = "number"),
    @FindBy(id = "account")
})
private WebElement cardNumber;
```

In this example, the `cardNumber` WebElement will be initialized if either an element with the ID `number` or an element with the ID `account` is found on the page. This effectively allows you to implement an "or" condition for locating elements

### Summary of Annotations

- **@FindBy**: Used for a single locator condition.
- **@FindBys**: Used for multiple conditions that must all be satisfied (AND condition).
- **@FindAll**: Used for multiple conditions where at least one must be satisfied (OR condition).

This flexibility allows you to accommodate various scenarios in your page object model while maintaining clear and maintainable code.

### Parameters
 In TestNG, you can pass parameters to your test methods directly from the testng.xml configuration file. This allows you to customize test execution without modifying the test method code.

 ```xml
 <test name="ParameterTest">
        <parameter name="username" value="testuser" />
        <parameter name="password" value="testpassword" />
        <classes>
            <class name="com.example.testng.ParameterExampleTest" />
        </classes>
    </test>
 ```

```java
    @Test
    @Parameters({ "username", "password" })
    public void testWithParameters(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Test logic using username and password
    }
```

## Assertions

Assertions in TestNG are used to verify expected outcomes during test execution.

- **Assert Equals**: Verifies if the actual value equals the expected value.
- **Assert True**: Checks if the given condition is true.
- **Assert False**: Checks if the given condition is false.
- **Assert Null**: Ensures that the object reference is null.
- **Assert Not Null**: Ensures that the object reference is not null.

## Listeners 

TestNG listeners are powerful tools for customizing test execution behavior and performing actions based on various test events. They enable you to implement logging, reporting, or custom handling of test outcomes, enhancing the control and visibility of your test automation framework

**CustomTestListener**: Implements ITestListener interface provided by TestNG, which includes methods to handle various test events (onStart, onFinish, onTestStart, onTestSuccess, onTestFailure, onTestSkipped, etc.).

**TestWithListener**: Uses @Listeners annotation to attach CustomTestListener to the test class. This ensures that the listener methods (CustomTestListener methods) are invoked during the corresponding test events.

```java
@Listeners(ListenersExample.class)
public class GroupingExample {}
```

### Choosing Between Static and Non-Static WebDriver

**Static Approach**: Use when you need a single WebDriver instance shared across multiple test classes for consistency, efficiency, and simplicity.

**Non-Static Approach**: Use when you require separate WebDriver instances with different configurations or lifecycle management per test class or method.  

## ITestResult 

The below line from TestNG listener,  is a class that can listen to events during the execution of a TestNG test. The purpose of this particular line is to retrieve the WebDriver instance being used in the test. Here's a detailed breakdown:

```java
WebDriver driver = ((BaseTest)result.getInstance()).getDriver();
```

1. **`result.getInstance()`**:
   - The `result` object is an instance of `ITestResult`, which holds information about the test method that was run. 
   - `getInstance()` returns the instance of the test class that contains the test method that was executed.

2. **`((BaseTest)result.getInstance())`**:
   - This casts the object returned by `result.getInstance()` to the `BaseTest` class. This cast is necessary if the `getDriver()` method is defined in `BaseTest`, which is a superclass of the actual test class. This ensures that you can call methods specific to `BaseTest`.

3. **`.getDriver()`**:
   - This calls the `getDriver()` method of the `BaseTest` class. The `getDriver()` method is  a method in `BaseTest` that returns the WebDriver instance used by the test.

4. **`WebDriver driver = ...`**:
   - This assigns the WebDriver instance retrieved from the `getDriver()` method to the local variable `driver`.

## Extent Reports

The combination of these classes allows you to generate detailed and informative HTML reports for your TestNG tests using the Extent Reports library.

1. `ExtentSparkReporter`:
   - The `ExtentSparkReporter` class is responsible for generating the HTML report file.
   - It is a part of the Extent Reports library and is used to define the configuration and settings for the report generation.
   - You can specify the output file name and location using the `ExtentSparkReporter` constructor.
   - It provides various methods to customize the report, such as setting the report name, theme, document title, etc.
   - Multiple reporters can be attached to an `ExtentReports` instance to generate reports in different formats or locations.

2. `ExtentReports`:
   - The `ExtentReports` class is the main class that represents the Extent Reports instance.
   - It acts as a central entity to which you attach reporters (`ExtentSparkReporter` in this case) and build the report.
   - The `ExtentReports` class provides methods to create tests, assign authors, add system info, and more.
   - It maintains a list of tests and their associated results.
   - You can create an instance of `ExtentReports` using the `createInstance()` method, which initializes the report and returns the instance.
   - At the end of the test execution, you need to call the `flush()` method on the `ExtentReports` instance to write the report to the output file.

3. `ExtentTest`:
   - The `ExtentTest` class represents a single test or a node in the report.
   - It is created using the `createTest()` method of the `ExtentReports` instance.
   - Each `ExtentTest` object corresponds to a specific test method or a test case in your framework.
   - You can use the `ExtentTest` object to log details about the test, such as steps, assertions, logs, screenshots, etc.
   - The `ExtentTest` class provides methods like `pass()`, `fail()`, `skip()`, `info()`, `log()`, etc., to record the test results and add information to the report.
   - You can create child tests or nested tests using the `createNode()` method of an `ExtentTest` object, allowing you to create a hierarchical structure in the report.

## Attaching screenshot on Failure to Report

```java
WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String screenshotPath = "data:image/png;base64," + screenshotBase64;
test.get().fail("Screenshot on failure", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
```

The line `String screenshotPath = "data:image/png;base64," + screenshotBase64;` is creating a Base64-encoded data URI for the screenshot image.
- `screenshotBase64` is a variable that holds the screenshot image as a Base64-encoded string. This string represents the binary data of the screenshot image encoded using the Base64 scheme.
- `"data:image/png;base64,"` is a prefix that specifies the data URI scheme and the content type of the image.
  - `data:` indicates that the URI contains data inline, rather than referencing an external resource.
  - `image/png` specifies the MIME type of the image, indicating that it is a PNG image.
  - `base64` specifies the encoding scheme used for the image data, which is Base64 in this case.
  - The comma (`,`) separates the content type from the actual Base64-encoded data.

By concatenating the prefix `"data:image/png;base64,"` with the `screenshotBase64` string, we create a complete data URI that represents the screenshot image.

For example, if the `screenshotBase64` variable contains the Base64-encoded string `"iVBORw0KGgoAAAANSUhEUgAAA..."`, the resulting `screenshotPath` will be:
```
"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAA..."
```

This data URI can be used as the source (src) attribute of an `<img>` tag in HTML to display the screenshot image directly within the web page, without the need for a separate image file.

In the context of Extent Reports, the `MediaEntityBuilder` class provides a method `createScreenCaptureFromBase64String()` that takes a Base64-encoded screenshot path and creates a screenshot entity that can be attached to the test report. By passing the `screenshotPath` to this method, the screenshot image is embedded within the Extent Reports HTML file, allowing it to be viewed alongside the test results.

Using data URIs for embedding screenshots in the report has the advantage of keeping the report self-contained and avoiding the need to manage separate image files.

## Some additional info about embedded images

In the code snippet provided, the screenshots are not stored as separate image files on the file system. Instead, they are embedded directly within the Extent Reports HTML file using data URIs.

When a test fails and a screenshot is captured, the following steps occur:
1. The screenshot is captured using the `TakesScreenshot` interface and the `getScreenshotAs(OutputType.BASE64)` method, which returns the screenshot as a Base64-encoded string.
2. The Base64-encoded string is concatenated with the data URI prefix (`"data:image/png;base64,"`) to create a complete data URI for the screenshot.
3. The data URI is passed to the `MediaEntityBuilder.createScreenCaptureFromBase64String()` method to create a screenshot entity.
4. The screenshot entity is attached to the test failure using `test.get().fail("Screenshot on failure", screenshotEntity)`.

When the Extent Reports HTML file is generated, the screenshot entities are embedded within the HTML file itself. The data URIs are used as the source (src) attribute of `<img>` tags, allowing the screenshots to be displayed directly within the report.

For example, in the generated HTML file, you might find an `<img>` tag like this:
```html
<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAA..." alt="Screenshot">
```

The `src` attribute contains the complete data URI of the screenshot, including the Base64-encoded image data.

By using data URIs, the screenshots are stored within the HTML file itself, eliminating the need for separate image files. This makes the Extent Reports HTML file self-contained and portable, as all the necessary information, including the screenshots, is contained within a single file.

However, it's worth noting that embedding large numbers of high-resolution screenshots directly within the HTML file can significantly increase the file size of the report. If you have a large number of test failures with screenshots, it may be more efficient to store the screenshots as separate image files and provide links to them in the report instead of embedding them using data URIs.

## Page Object Model

The Page Object Model (POM) is a design pattern used in test automation to create an object repository for web elements. It enhances test maintenance and reduces code duplication.

The line `PageFactory.initElements(driver, this);` is a key component of the Page Object Model (POM) in Selenium. Let's break it down:

### PageFactory.initElements(driver, this)

The `PageFactory` class in Selenium is used to initialize web elements that are defined in the page classes using `@FindBy` annotations. This process is known as "lazy initialization," where the web elements are not located until they are used in the test.

#### Components of the Line

1. **PageFactory**: 
   - This is a class provided by Selenium that supports the Page Object Model by providing methods to initialize web elements.

2. **initElements**: 
   - This is a static method of the `PageFactory` class.
   - It initializes all the `@FindBy` annotated fields in the page object.

3. **driver**: 
   - This is the instance of `WebDriver` that is passed to the method.
   - It is used to interact with the browser and find the web elements.

4. **this**: 
   - This refers to the current instance of the page object (the class where this line is called).
   - It means that the web elements in the current page object class should be initialized.

#### How It Works

When you call `PageFactory.initElements(driver, this);` in the constructor of a page class, it performs the following steps:

1. **Scanning for Annotations**: 
   - The `PageFactory` scans the current class (`this`) for fields annotated with `@FindBy`, `@FindAll`, or `@FindBys`.

2. **Locating Elements**: 
   - For each annotated field, it uses the provided locator (e.g., `@FindBy(id = "username")`) to find the corresponding web element on the webpage.

3. **Initializing Fields**: 
   - It initializes the annotated fields with proxy objects. These proxy objects are not the actual web elements but are capable of finding the elements when they are used.
   - This is known as lazy initialization because the actual web elements are only located when they are accessed in the code.

#### Example

Let's see the example of the `LoginPage` class:

```java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initializes the web elements
    }

    public void setUsername(String user) {
        username.sendKeys(user);  // Uses the initialized web element
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);  // Uses the initialized web element
    }

    public void clickLoginButton() {
        loginButton.click();  // Uses the initialized web element
    }
}
```

In this example:

- When `LoginPage` is instantiated, the constructor calls `PageFactory.initElements(driver, this);`.
- The `PageFactory` scans the `LoginPage` class for fields annotated with `@FindBy`.
- It initializes the `username`, `password`, and `loginButton` fields with proxy objects.
- When the `setUsername`, `setPassword`, or `clickLoginButton` methods are called, these proxy objects find the actual web elements on the webpage and interact with them.

This approach helps keep the code clean and organized, as the locators for web elements are separated from the test logic, making it easier to maintain and reuse.

## Key Differences between @FindBys and @FindAll

In Selenium's Page Factory, `@FindAll` and `@FindBys` are used to locate web elements, but they serve different purposes. Here's a detailed explanation of each annotation and their differences:

### `@FindAll`

`@FindAll` is used to find web elements that match any of the given criteria. It is equivalent to a logical OR operation. The element will be matched if it satisfies at least one of the specified locators.

#### Example:

```java
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

@FindAll({
    @FindBy(id = "submit"),
    @FindBy(name = "submitButton")
})
private WebElement submitButton;
```

In this example, the `submitButton` will be located if it has either the ID "submit" or the name "submitButton".

### `@FindBys`

`@FindBys` is used to find web elements that match all of the given criteria in a nested manner. It is equivalent to a logical AND operation. The element must satisfy all of the specified locators in sequence.

#### Example:

```java
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindBy;

@FindBys({
    @FindBy(className = "form-group"),
    @FindBy(tagName = "input"),
    @FindBy(id = "username")
})
private WebElement usernameField;
```

In this example, the `usernameField` will be located if it is inside an element with the class name "form-group" and a tag name "input", and it has the ID "username".

### Key Differences:

1. **Logical Operation:**
   - `@FindAll` uses a logical OR operation, meaning any of the criteria can match.
   - `@FindBys` uses a logical AND operation, meaning all criteria must match in the specified order.

2. **Usage:**
   - `@FindAll` is useful when an element can be identified by multiple locators, and you want to use whichever one is found.
   - `@FindBys` is useful when you need to narrow down an element within a specific context or a nested structure..


## Fluent Interface

The Fluent Interface pattern is a method of designing object-oriented APIs in such a way that multiple method calls can be chained together, making the code more readable and expressive. In the context of the Page Object Model (POM) in Selenium, it allows you to chain methods in a way that simulates natural language.

### Fluent Interface Characteristics

1. **Method Chaining**: Methods return the current object (`this`), allowing multiple method calls to be chained in a single statement.
2. **Improved Readability**: Code that uses a fluent interface reads more like natural language, making it easier to understand.
3. **Better Organization**: Helps in organizing actions and validations within page objects, providing a clean and structured approach.

### Implementing Fluent Interface in POM

To implement a fluent interface, ensure that each method in your page class returns the instance of the page object (`this`). This allows you to chain method calls together.

#### Example

Here’s an example to demonstrate how to implement and use the Fluent Interface in a page object class:

```java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUsername(String user) {
        username.sendKeys(user);
        return this; // Returning the current instance
    }

    public LoginPage enterPassword(String pass) {
        password.sendKeys(pass);
        return this; // Returning the current instance
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver); // Navigating to a new page
    }

    public LoginPage verifyErrorMessage(String expectedMessage) {
        String actualMessage = errorMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected: " + expectedMessage + ", but got: " + actualMessage);
        }
        return this; // Returning the current instance
    }
}
```

### Using Fluent Interface in Tests

When writing test cases, you can now chain method calls to perform actions and assertions in a readable manner:

```java
package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        HomePage homePage = new LoginPage(driver)
                                .enterUsername("testuser")
                                .enterPassword("testpassword")
                                .clickLoginButton();

        // Assertions to verify successful login
    }

    @Test
    public void testUnsuccessfulLogin() {
        new LoginPage(driver)
            .enterUsername("wronguser")
            .enterPassword("wrongpassword")
            .clickLoginButton()
            .verifyErrorMessage("Invalid username or password.");

        // No need to navigate to HomePage as login should fail
    }
}
```

### Benefits of Fluent Interface in POM

1. **Enhanced Readability**: The test code is more readable and resembles natural language, making it easier to understand.
2. **Concise Code**: Reduces boilerplate code and helps to write concise tests.
3. **Maintainability**: Easier to maintain and extend, as changes to page interactions are localized to the page object methods.
4. **Error Handling**: Can incorporate error handling within the page methods, ensuring consistent error messages and handling.
Certainly! Here's a summary of what you've done to automate the handling of save dialog boxes using AutoIt with Selenium Java:

## AutoIt and Selenium Integration for Save Dialog Handling

### 1. AutoIt Script Setup

1. Download AutoIt -https://www.autoitscript.com/site/autoit/downloads/
2. Created a .au3 file with the following script:

```autoit
#include <FileConstants.au3>

WinWaitActive("Save As")
Send("Test.xlsx")
Send("{ENTER}")

$overwriteDialog = WinWait("Confirm Save As", "", 5)
If $overwriteDialog Then
    ControlClick($overwriteDialog, "", "&Yes")
EndIf

Sleep(2000)
```

3. Compiled the .au3 file into an executable named "handle_save_dialog.exe". Right click and click compile script

### 2. Java Integration

Added the following code to your Java Selenium project to execute the AutoIt script:

```java
try {
    Runtime.getRuntime().exec(System.getProperty("user.dir") + 
        File.separator + "src" + File.separator + "main" + 
        File.separator + "resources" + File.separator + 
        "handle_save_dialog.exe");
} catch (IOException e) {
    throw new RuntimeException(e);
}
```

### 3. Functionality

- The AutoIt script waits for the "Save As" dialog to appear
- It then enters the filename "Test.xlsx" and presses Enter
- If a "Confirm Save As" dialog appears (file already exists), it clicks "Yes" to overwrite
- The script waits for 2 seconds to allow the download to complete
- The Java code executes this AutoIt script when needed in the Selenium test

### 4. Best Practices

- Ensure the AutoIt executable is in the correct resource folder of your Java project
- Add appropriate error handling and logging in your Java code
- Consider parameterizing the file name and wait times for flexibility
- Test the integration with various scenarios (new file, existing file, different file types)

This setup allows you to handle save dialogs in your Selenium Java tests by leveraging AutoIt's ability to interact with Windows dialogs.

## Javascript to check if an element is clickable or not 
```javascript
// Function to check if an element is clickable
function isElementClickable(xpath) {
  try {
    const element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element && element.offsetParent !== null && element.offsetWidth > 0 && element.offsetHeight > 0) {
      const rect = element.getBoundingClientRect();
      const isOverlapped = document.elementFromPoint(rect.left + rect.width / 2, rect.top + rect.height / 2) !== element;
      return !isOverlapped && element.style.display !== 'none' && element.style.visibility !== 'hidden';
    }
    return false;
  } catch (error) {
    console.error('Error checking element clickability:', error);
    return false;
  }
}

// Check if the target element is clickable
const targetXPath = "//label[@automation-id='digitalShopCardCheckboxButton']";
if (isElementClickable(targetXPath)) {
  console.log('The element is clickable');
} else {
  console.log('The element is not clickable');
}
```
### Best Practices for Fluent Interface

1. **Consistent Return Types**: Ensure methods return the appropriate page object instance to maintain the chain.
2. **Clear Method Names**: Use descriptive method names that clearly indicate the action being performed.
3. **Logical Grouping**: Group related actions and validations together to enhance readability and organization.

By following these practices, you can effectively use the Fluent Interface pattern in your Page Object Model to create clean, readable, and maintainable test automation code.
