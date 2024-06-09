# CoreJavaNSeleniumNSeleniumForMe

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
