# CoreJavaForMe
## Xpath
Table summarizing the important XPath syntax with their formulas:

| XPath Syntax                                   | Description                                                  | Example                                                 |
| ---------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------- |
| `//tagname`                                    | Selects all nodes with the name `tagname` anywhere in the document. | `//div` selects all `<div>` elements.                   |
| `//*`                                          | Selects all elements in the document.                        | `//*` selects all elements in the document.             |
| `/tagname`                                     | Selects the root node with the name `tagname`.              | `/html` selects the root `<html>` element.             |
| `/tagname/subtagname`                         | Selects a child node `subtagname` of the `tagname` node.    | `/div/span` selects all `<span>` elements inside `<div>` |
| `//tagname[@attribute='value']`               | Selects all nodes with the name `tagname` that have an attribute `attribute` with the value `value`. | `//input[@type='text']` selects all text `<input>` elements. |
| `//tagname[position()=n]`                     | Selects the `n`th `tagname` element.                        | `//tr[position()=3]` selects the third `<tr>` element.  |
| `//tagname[last()]`                           | Selects the last `tagname` element.                         | `//p[last()]` selects the last `<p>` element.          |
| `//tagname[contains(@attribute, 'value')]`    | Selects all nodes with the name `tagname` where the attribute `attribute` contains the substring `value`. | `//a[contains(@href, 'example')]` selects all `<a>` elements with `href` containing "example". |
| `//tagname[starts-with(@attribute, 'value')]` | Selects all nodes with the name `tagname` where the attribute `attribute` starts with the substring `value`. | `//img[starts-with(@src, 'images/')]` selects all `<img>` elements with `src` starting with "images/". |
| `//tagname[text()='value']`                   | Selects all nodes with the name `tagname` that have the exact text content `value`. | `//h1[text()='Welcome']` selects the `<h1>` with text "Welcome". |
| `//tagname[contains(text(), 'value')]`        | Selects all nodes with the name `tagname` that contain the substring `value` in their text content. | `//p[contains(text(), 'Lorem ipsum')]` selects all `<p>` elements containing "Lorem ipsum" in their text. |
| `//tagname[@attribute='value1' or @attribute='value2']` | Selects all nodes with the name `tagname` where the attribute `attribute` is either `value1` or `value2`. | `//input[@type='text' or @type='password']` selects all `<input>` elements with type "text" or "password". |
| `//tagname[@attribute='value1' and @attribute2='value2']` | Selects all nodes with the name `tagname` where `attribute` is `value1` and `attribute2` is `value2`. | `//div[@class='container' and @id='main']` selects all `<div>` elements with class "container" and id "main". |
| `//tagname/..`                                 | Selects the parent of the `tagname` element.                 | `//p/..` selects the parent of all `<p>` elements.      |
