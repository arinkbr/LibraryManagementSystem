import com.library.domain.*;
import com.library.utils.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    @DisplayName("testBorrowItem1: Borrow succeeds when valid student borrows available book")
    void testBorrowItem1() {

        Library library = new Library();

        Student student = new Student("Alex");

        Book book = new Book(
                "Percy Jackson",
                Item.Status.IN_STORE,
                "9781423103349",
                "Rick Riordan",
                "Fantasy"
        );

        library.getUsers().add(student);
        library.getItems().add(book);

        library.borrowItem(student, book);

        assertTrue(student.getBorrowedItems().contains(book));

        assertEquals(Item.Status.BORROWED, book.getStatus());
    }

    @Test
    @DisplayName("testBorrowItem2: Borrow fails when user is not in library")
    void testBorrowItem2() {

        Library library = new Library();

        Student student = new Student("Emma");

        Book book = new Book(
                "Dune",
                Item.Status.IN_STORE,
                "9780441172719",
                "Frank Herbert",
                "Science Fiction"
        );

        library.getItems().add(book);

        assertThrows(
                RuntimeException.class,
                () -> library.borrowItem(student, book)
        );
    }

    @Test
    @DisplayName("testBorrowItem3: Borrow fails when item is not in library")
    void testBorrowItem3() {

        Library library = new Library();

        Student student = new Student("Nathan");

        Book book = new Book(
                "1984",
                Item.Status.IN_STORE,
                "9780451524935",
                "George Orwell",
                "Dystopian"
        );

        library.getUsers().add(student);

        assertThrows(
                RuntimeException.class,
                () -> library.borrowItem(student, book)
        );
    }

    @Test
    @DisplayName("testBorrowItem4: Borrow fails when item already borrowed")
    void testBorrowItem4() {

        Library library = new Library();

        Student student1 = new Student("Sophia");
        Student student2 = new Student("Lucas");

        Book book = new Book(
                "The Hobbit",
                Item.Status.IN_STORE,
                "9780547928227",
                "J.R.R Tolkien",
                "Fantasy"
        );

        library.getUsers().add(student1);
        library.getUsers().add(student2);

        library.getItems().add(book);

        library.borrowItem(student1, book);

        assertThrows(
                RuntimeException.class,
                () -> library.borrowItem(student2, book)
        );
    }

    @Test
    @DisplayName("testBorrowItem5: Student cannot borrow DVD")
    void testBorrowItem5() {

        Library library = new Library();

        Student student = new Student("Olivia");

        DVD dvd = new DVD(
                "Interstellar",
                Item.Status.IN_STORE,
                "Christopher Nolan",
                169
        );

        library.getUsers().add(student);
        library.getItems().add(dvd);

        assertThrows(
                RuntimeException.class,
                () -> library.borrowItem(student, dvd)
        );
    }

    @Test
    @DisplayName("testBorrowItem6: Student cannot borrow magazine")
    void testBorrowItem6() {

        Library library = new Library();

        Student student = new Student("Daniel");

        Magazine magazine = new Magazine(
                "Science Weekly",
                Item.Status.IN_STORE,
                45,
                "Nature"
        );

        library.getUsers().add(student);
        library.getItems().add(magazine);

        assertThrows(
                RuntimeException.class,
                () -> library.borrowItem(student, magazine)
        );
    }

    @Test
    @DisplayName("testBorrowItem7: Student cannot exceed borrow limit")
    void testBorrowItem7() {

        Library library = new Library();

        Student student = new Student("Leo");

        library.getUsers().add(student);

        for (int i = 0; i < Constants.MAX_BOOKS_STUDENT; i++) {

            Book book = new Book(
                    "Book" + i,
                    Item.Status.IN_STORE,
                    "9780439023481",
                    "Author",
                    "Fantasy"
            );

            library.getItems().add(book);

            library.borrowItem(student, book);
        }

        Book extraBook = new Book(
                "Overflow",
                Item.Status.IN_STORE,
                "9780439023481",
                "Author",
                "Fantasy"
        );

        library.getItems().add(extraBook);

        assertThrows(
                RuntimeException.class,
                () -> library.borrowItem(student, extraBook)
        );
    }

    @Test
    @DisplayName("testBorrowItem8: Teacher can borrow DVD")
    void testBorrowItem8() {

        Library library = new Library();

        Teacher teacher = new Teacher("Michael");

        DVD dvd = new DVD(
                "Inception",
                Item.Status.IN_STORE,
                "Christopher Nolan",
                148
        );

        library.getUsers().add(teacher);
        library.getItems().add(dvd);

        library.borrowItem(teacher, dvd);

        assertTrue(
                teacher.getBorrowedItems().contains(dvd)
        );

        assertEquals(
                Item.Status.BORROWED,
                dvd.getStatus()
        );
    }

    @Test
    @DisplayName("testBorrowItem9: Teacher cannot exceed borrow limit")
    void testBorrowItem9() {

        Library library = new Library();

        Teacher teacher = new Teacher("Grace");

        library.getUsers().add(teacher);

        for (int i = 0; i < Constants.MAX_ITEMS_TEACHER; i++) {

            Book book = new Book(
                    "Book" + i,
                    Item.Status.IN_STORE,
                    "9780439023481",
                    "Author",
                    "Programming"
            );

            library.getItems().add(book);

            library.borrowItem(teacher, book);
        }

        Book extraBook = new Book(
                "Extra",
                Item.Status.IN_STORE,
                "9780439023481",
                "Author",
                "Programming"
        );

        library.getItems().add(extraBook);

        assertThrows(
                RuntimeException.class,
                () -> library.borrowItem(teacher, extraBook)
        );
    }

    @Test
    @DisplayName("testReturnItem1: Valid return succeeds")
    void testReturnItem1() {

        Library library = new Library();

        Student student = new Student("Emma");

        Book book = new Book(
                "Atomic Habits",
                Item.Status.IN_STORE,
                "9780735211292",
                "James Clear",
                "Self Help"
        );

        library.getUsers().add(student);
        library.getItems().add(book);

        library.borrowItem(student, book);

        library.returnItem(student, book);

        assertFalse(
                student.getBorrowedItems().contains(book)
        );

        assertEquals(
                Item.Status.IN_STORE,
                book.getStatus()
        );
    }

    @Test
    @DisplayName("testReturnItem2: Return fails when item was never borrowed")
    void testReturnItem2() {

        Library library = new Library();

        Student student = new Student("Aiden");

        Book book = new Book(
                "Dracula",
                Item.Status.IN_STORE,
                "9780486411095",
                "Bram Stoker",
                "Horror"
        );

        assertThrows(
                RuntimeException.class,
                () -> library.returnItem(student, book)
        );
    }

    @Test
    @DisplayName("testReturnItem3: Borrowed list becomes empty after return")
    void testReturnItem3() {

        Library library = new Library();

        Student student = new Student("Noah");

        Book book = new Book(
                "Frankenstein",
                Item.Status.IN_STORE,
                "9780486282114",
                "Mary Shelley",
                "Horror"
        );

        library.getUsers().add(student);
        library.getItems().add(book);

        library.borrowItem(student, book);

        library.returnItem(student, book);

        assertTrue(
                student.getBorrowedItems().isEmpty()
        );
    }

    @Test
    @DisplayName("testSearch1: Stream search finds matching title")
    void testSearch1() {

        Library library = new Library();

        Book book = new Book(
                "Clean Code",
                Item.Status.IN_STORE,
                "9780132350884",
                "Robert Martin",
                "Programming"
        );

        library.getItems().add(book);

        List<Item> result =
                library.search(
                        "Clean",
                        Library.SearchType.STREAM
                );

        assertTrue(result.contains(book));
    }

    @Test
    @DisplayName("testSearch2: Stream search finds matching author")
    void testSearch2() {

        Library library = new Library();

        Book book = new Book(
                "It",
                Item.Status.IN_STORE,
                "9781501142970",
                "Stephen King",
                "Horror"
        );

        library.getItems().add(book);

        List<Item> result =
                library.search(
                        "Stephen King",
                        Library.SearchType.STREAM
                );

        assertTrue(result.contains(book));
    }

    @Test
    @DisplayName("testSearch3: Recursive search finds matching title")
    void testSearch3() {
        Library library = new Library();
        Book book = new Book(
                "The Alchemist",
                Item.Status.IN_STORE,
                "9780061122415",
                "Paulo Coelho",
                "Adventure"
        );

        library.getItems().add(book);
        List<Item> result =
                library.search(
                        "Alchemist",
                        Library.SearchType.RECURSIVE
                );

        assertTrue(result.contains(book));
    }

    @Test
    @DisplayName("testSearch4: Recursive search finds matching author")
    void testSearch4() {

        Library library = new Library();

        Book book = new Book(
                "The Shining",
                Item.Status.IN_STORE,
                "9780307743657",
                "Stephen King",
                "Horror"
        );

        library.getItems().add(book);

        List<Item> result =
                library.search(
                        "Stephen King",
                        Library.SearchType.RECURSIVE
                );

        assertTrue(result.contains(book));
    }

    @Test
    @DisplayName("testSearch5: Search returns empty list when no item matches")
    void testSearch5() {

        Library library = new Library();

        Book book = new Book(
                "Divergent",
                Item.Status.IN_STORE,
                "9780062024039",
                "Veronica Roth",
                "Science Fiction"
        );

        library.getItems().add(book);

        List<Item> result =
                library.search(
                        "Batman",
                        Library.SearchType.STREAM
                );

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("testGenerateReport1: Admin generates report successfully")
    void testGenerateReport1() {

        Library library = new Library();

        Admin admin = new Admin("Sarah");

        library.getUsers().add(admin);

        Book book = new Book(
                "Maze Runner",
                Item.Status.IN_STORE,
                "9780385737951",
                "James Dashner",
                "Science Fiction"
        );

        library.getItems().add(book);

        Map<Item.Status, List<Item>> report =
                library.generateReport(admin);

        assertFalse(report.isEmpty());
    }

    @Test
    @DisplayName("testGenerateReport2: Student cannot generate report")
    void testGenerateReport2() {

        Library library = new Library();

        Student student = new Student("Chris");

        assertThrows(
                RuntimeException.class,
                () -> library.generateReport(student)
        );
    }

    @Test
    @DisplayName("testGenerateReport3: Borrowed items appear under BORROWED")
    void testGenerateReport3() {

        Library library = new Library();

        Admin admin = new Admin("David");

        Student student = new Student("Lucas");

        library.getUsers().add(admin);
        library.getUsers().add(student);

        Book book = new Book(
                "1984",
                Item.Status.IN_STORE,
                "9780451524935",
                "George Orwell",
                "Dystopian"
        );

        library.getItems().add(book);

        library.borrowItem(student, book);

        Map<Item.Status, List<Item>> report =
                library.generateReport(admin);

        assertTrue(
                report.get(Item.Status.BORROWED).contains(book)
        );
    }

    @Test
    @DisplayName("testGenerateReport4: Lost items appear under LOST")
    void testGenerateReport4() {

        Library library = new Library();

        Admin admin = new Admin("Henry");

        Student student = new Student("Mia");

        library.getUsers().add(admin);
        library.getUsers().add(student);

        Book book = new Book(
                "The Maze Runner",
                Item.Status.IN_STORE,
                "9780385737951",
                "James Dashner",
                "Science Fiction"
        );

        library.getItems().add(book);

        library.borrowItem(student, book);

        book.setStatus(Item.Status.LOST);

        Map<Item.Status, List<Item>> report =
                library.generateReport(admin);

        assertTrue(
                report.get(Item.Status.LOST).contains(book)
        );
    }

    @Test
    @DisplayName("testGenerateReport5: In-store items appear under IN_STORE")
    void testGenerateReport5() {

        Library library = new Library();

        Admin admin = new Admin("Emma");

        library.getUsers().add(admin);

        Book book = new Book(
                "Harry Potter",
                Item.Status.IN_STORE,
                "9780439708180",
                "J.K Rowling",
                "Fantasy"
        );

        library.getItems().add(book);

        Map<Item.Status, List<Item>> report =
                library.generateReport(admin);

        assertTrue(
                report.get(Item.Status.IN_STORE).contains(book)
        );
    }

    @Test
    @DisplayName("testBackup1: Admin can execute backup")
    void testBackup1() {

        Library library = new Library();

        Admin admin = new Admin("Olivia");

        library.getUsers().add(admin);

        assertDoesNotThrow(
                () -> library.backup(admin)
        );
    }

    @Test
    @DisplayName("testBackup2: Student cannot execute backup")
    void testBackup2() {

        Library library = new Library();

        Student student = new Student("Liam");

        assertThrows(
                RuntimeException.class,
                () -> library.backup(student)
        );
    }

    @Test
    @DisplayName("testInit1: Library initializes successfully from CSV")
    void testInit1() {

        Library library = Library.init();

        assertNotNull(library);

        assertFalse(library.getItems().isEmpty());

        assertFalse(library.getUsers().isEmpty());
    }
}