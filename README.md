# CoreJavaForMe
## Xpath
Table summarizing the important XPath syntax with their formulas:

| XPath Syntax                                   | Description                                                  |
| ---------------------------------------------- | ------------------------------------------------------------ |
| `//tagname`                                    | Selects all nodes with the name `tagname` anywhere in the document. |
| `//*`                                          | Selects all elements in the document.                        |
| `/tagname`                                     | Selects the root node with the name `tagname`.              |
| `/tagname/subtagname`                         | Selects a child node `subtagname` of the `tagname` node.    |
| `//tagname[@attribute='value']`               | Selects all nodes with the name `tagname` that have an attribute `attribute` with the value `value`. |
| `//tagname[position()=n]`                     | Selects the `n`th `tagname` element.                        |
| `//tagname[last()]`                           | Selects the last `tagname` element.                          |
| `//tagname[contains(@attribute, 'value')]`    | Selects all nodes with the name `tagname` where the attribute `attribute` contains the substring `value`. |
| `//tagname[starts-with(@attribute, 'value')]` | Selects all nodes with the name `tagname` where the attribute `attribute` starts with the substring `value`. |
| `//tagname[text()='value']`                   | Selects all nodes with the name `tagname` that have the exact text content `value`. |
| `//tagname[contains(text(), 'value')]`        | Selects all nodes with the name `tagname` that contain the substring `value` in their text content. |
| `//tagname[@attribute='value1' or @attribute='value2']` | Selects all nodes with the name `tagname` where the attribute `attribute` is either `value1` or `value2`. |
| `//tagname[@attribute='value1' and @attribute2='value2']` | Selects all nodes with the name `tagname` where `attribute` is `value1` and `attribute2` is `value2`. |
| `//tagname/..`                                 | Selects the parent of the `tagname` element.                 |
