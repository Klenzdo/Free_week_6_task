package SchoolLibrary.service.Impl;

import SchoolLibrary.service.LibraryService;
import SchoolLibrary.model.Book;
import SchoolLibrary.model.Library;
import SchoolLibrary.model.Person;
import SchoolLibrary.utils.PersonPriorityComparator;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LibraryServiceImpl implements LibraryService {

    private final Library library;
    public LibraryServiceImpl (Library library){
        this.library=library;
    }

    public List<Book> getCollection() {
        return library.getCollection();
    }
    @Override
    public void borrowBookByPriority(List<Person> borrowers, String isbn){
        Book book = findByISBN(isbn);
        Queue<Person> queue = new PriorityQueue<>(new PersonPriorityComparator());
        queue.addAll(borrowers);
        performBorrowBook(queue, book);
        }
        private void performBorrowBook(Queue<Person> queue, Book book){
            queue.stream().filter(person -> {
                if(person.canBorrow(book)){
                    book.setCopies(book.getCopies() - 1);
                    return true;
                }else {
                    throw new RuntimeException("Book copies all borrowed");
                }
            }).forEach(person -> System.out.println(person.getRole().name() + " Successfully borrowed book" + " " + book.getTitle() + " " + book.getIsbn() ) );
    }



    @Override
    public void borrowBookByFifo(List<Person> borrowers, String isbn) {
        Book book = findByISBN(isbn);
        Queue<Person> personQueue = new LinkedList<>(borrowers);
        performBorrowBook(personQueue, book);

    }


    public Book findByISBN (String isbn){
        return getCollection().stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .findAny()
                .orElseThrow(() -> new RuntimeException("book not found"));


    }


}

