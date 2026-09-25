# Web Element Handling

## Checkboxes

Checkboxes are form elements that can be selected or unselected.

### Selecting a Specific Checkbox

Use `click()` on the required checkbox element.

### Selecting Multiple Checkboxes

Use `findElements()` to locate multiple checkbox elements.

The returned `List<WebElement>` can be processed using a loop.

### Selecting the Last N Checkboxes

Formula:

`Total number of checkboxes - Number of checkboxes to select = Starting index`

Remember that List indexing starts from `0`.

### Selecting the First N Checkboxes

Use a loop starting from index `0` and continue for the required number of checkboxes.

### Unselecting Checkboxes

Use `isSelected()` to check whether a checkbox is selected.

If it is selected, use `click()` to unselect it.
