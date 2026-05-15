# User Manual

## 1. Setting Up the Library

The library system can be started in two different ways based on whether you want an empty library or one loaded with data from CSV files.

### Option A:
Create a blank library manually using:
```java
Library library = new Library();
```

You can then create and add users or items through their corresponding constructors.

### Option B:
You may also create a library using existing CSV files that already contain user and item data:

```java
Library library = Library.init();
```

The `init()` method loads information from the `users.csv` and `items.csv` files.

### CSV Structure for Items and Users

Every line inside these files must respect a specific format so the system can properly transform them into `User` and `Item` objects.

Each entry in `items.csv` corresponds to one item and follows this format:

`itemType,itemName,itemStatus,...(extra fields depending on the item type)`

#### Mandatory fields:
- `itemType` : specifies the item category (`book`, `dvd`, `magazine`)
- `itemName` : the title or name of the item
- `itemStatus` : the current condition/status of the item (`INSTORE`, `BORROWED`, `LOST`)

#### Extra fields:
Different item types require additional information:
- Book: requires `ISBN`, `author`, and `genre`
- DVD: requires `director` and `runtime`
- Magazine: requires `issueNumber` and `publisher`

#### Example:
```text
book,Java for beginners,instore,9780439023481,James,educational
dvd,Movie,borrowed,Bob R.,118
magazine,Generic Magazine,lost,18,Bill R.
```

Likewise, every line in `users.csv` represents one user and follows this structure:

`userType,userName`

#### Users only require two fields:
- `userType`: identifies the user category (`student`, `teacher`, `admin`)
- `userName`: the name of the user

#### Example:
```text
student,Bob
teacher,Bill
admin,James
```

## 2. Borrowing Library Items

Items can be borrowed through the `borrowItem()` method called from a `Library` instance:

```java
library.borrowItem(student, book);
```

#### Conditions:
- Both the user and the item must already exist in the library
- The item must currently have the `INSTORE` status
- Students are restricted to borrowing books only
- Borrowing limits cannot be surpassed (5 items for students, 10 for teachers)

## 3. Returning Library Items

Users may return borrowed items using the `returnItem()` method through the `Library` object:

```java
library.returnItem(student, book);
```

If the item exists in the user’s borrowed items collection, it is removed from that list and its status changes back to `INSTORE`.

## 4. Item Search

The system allows users to search for items using the `search()` method:

```java
List<Item> result = library.search(keyword, Library.STREAM);
```

The second parameter determines which search method is used:
- `Library.STREAM`
- `Library.RECURSIVE`

The method returns a list containing all matching items.

The search functionality checks:
- Item names/titles
- Book authors (if applicable)

## 5. Reports (Admin Only)

Administrators are able to generate reports listing all items grouped by status (`BORROWED`, `INSTORE`, and `LOST`):

```java
Map<Item.Status, List<Item>> report = library.generateReport(admin);
```

This returns a map where items are organized according to their current status and can later be displayed in the console.

## 6. Creating Backups (Admin Only)

Administrators can create backups of both users and items into CSV files whose file paths are defined inside `Constants.java`:
- `ITEMS_BACKUP_CSV_PATH`
- `USERS_BACKUP_CSV_PATH`

```java
library.backup(admin);
```

This generates two backup CSV files representing the current state of the library system.