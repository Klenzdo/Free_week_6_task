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

    private Library library;
    public LibraryServiceImpl (Library library){
        this.library=library;
    }

    public List<Book> getCollection() {
        return library.getCollection();
    }
    @Override
    public void borrowBookByPriority(List<Person> borrowers, String isbn){
        Book book = findByISBN(isbn);
        PriorityQueue<Person> queue = new PriorityQueue<>(new PersonPriorityComparator());
        queue.addAll(borrowers);
        while(!queue.isEmpty()){
            Person person = queue.poll();
            if(person.canBorrow(book)){
                book.setCopies(book.getCopies() - 1);
                System.out.println(person.getRole().name() + " Successfully borrowed book" + " " + book.getTitle() + " " + book.getIsbn() );
            }else{
                System.out.println("Book is not available");
            }

        }

    }

    @Override
    public void borrowBookByFifo(List<Person> borrowers, String isbn) {
        Book book = findByISBN(isbn);
        Queue<Person> personQueue = new LinkedList<>(borrowers);
        while(!personQueue.isEmpty()){
            Person person = personQueue.poll();
            if(person.canBorrow(book)){
                book.setCopies(book.getCopies() - 1);
                System.out.println(person.getRole().name() + " Successfully borrowed" + " " + book.getTitle() + " " + book.getIsbn());
            }else{
                System.out.println("Book is not available");
            }

        }

    }
    public Book findByISBN (String isbn){
        for(Book book: library.getCollection()){
            if (book.getIsbn().equalsIgnoreCase(isbn)){
                return book;
            }
        }
        throw new RuntimeException("book not found");

    }


}
