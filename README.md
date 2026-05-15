# Final Project

## Author: Arin Kabir 2537760

This is the final project for the Data Structures and Object-Oriented Programming course at Vanier College

### Explanation:
This project is a Library Management System made in Java using Object-Oriented Programming and Lombok to keep the code cleaner and easier to manage. The program includes different user roles such as Student, Teacher, and Admin, along with item types like Book. Everything is managed through a main `Library` class that handles borrowing, returning, searching, reports, and backups.

The system follows different rules depending on the user role, such as borrowing limits and permissions. It also keeps track of each item’s status (`INSTORE`, `BORROWED`, `LOST`). The program supports two search methods: stream search and recursive search. Admin users have extra permissions that allow them to generate reports grouping items by status and create backups that save the current library data.

For more information on how to use the program, refer to the [user guide](./USER_GUIDE.md).

### Class Diagram:

![diagram](src/main/resources/ClassDiagram)