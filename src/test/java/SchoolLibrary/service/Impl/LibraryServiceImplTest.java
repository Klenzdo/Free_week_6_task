package SchoolLibrary.service.Impl;

import SchoolLibrary.enums.Role;
import SchoolLibrary.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {

    private LibraryServiceImpl libraryService;
    private List<Book> books;
    private Library library;
    @BeforeEach
    public void init(){
        books = new ArrayList<>();
        books.add(new Book("Things Fall Apart", "123-456", 2));
        library = new Library(books);
        libraryService = new LibraryServiceImpl(library);

    }

    @Test
    void getCollection() {
        List<Book> collection = libraryService.getCollection();
        assertNotNull(collection, "The collection should not be null");
        assertEquals(books.size(), collection.size(), "The collection size should match the initial size");
    }

    @Test
    void borrowBookByPriority() {
        Person teacher = new Teacher("Freedom", "Male", 40, 1);
        Person seniorStudent = new Student("Ben", "Male", 22, 2, Role.SENIOR_STUDENT);
        Person juniorStudent = new Student ("Oluchi", "Female", 18, 3, Role.JUNIOR_STUDENT);

        List<Person> borrowers = List.of(juniorStudent, seniorStudent, teacher);
        libraryService.borrowBookByPriority(borrowers, "123-456");

        Book book = libraryService.findByISBN("123-456");
        assertEquals (0, book.getCopies());
    }

    @Test
    void borrowBookByFifo() {
        Person student1 = new Student("Ben", "Male", 22, 3, Role.SENIOR_STUDENT);
        Person student2 = new Student("Ogechi", "Female", 18, 4, Role.JUNIOR_STUDENT);
        List<Person> borrowers = List.of(student1, student2);
        libraryService.borrowBookByFifo(borrowers, "123-456");
        Book book = libraryService.findByISBN("123-456");
        assertEquals(0, book.getCopies());
    }

    @Test
    void findByISBN() {
        Book book = libraryService.findByISBN("123-456");
        assertNotNull(book, "Book should not null when found");
        assertEquals("Things Fall Apart", book.getTitle(), "The book title should match the returned book");
        assertEquals("123-456", book.getIsbn(), "The book ISBN should match the requested ISBN");
    }
}