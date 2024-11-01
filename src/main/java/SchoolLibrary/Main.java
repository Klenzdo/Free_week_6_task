package SchoolLibrary;

import SchoolLibrary.service.Impl.LibraryServiceImpl;
import SchoolLibrary.service.LibraryService;
import SchoolLibrary.enums.Role;
import SchoolLibrary.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Teacher("Freedom Agwaigbo", "Male", 35, 2005);
        Person person4 = new Teacher("Sandra Okeke", "Female", 35, 2007);
        Person person2 = new Student("Kosi Collins", "Male", 15, 2021, Role.SENIOR_STUDENT);
        Person person3 = new Student("Adaku Nnanna", "Female", 12, 2024, Role.JUNIOR_STUDENT);



        System.out.println("******** WELCOME TO FREEDOM LIBRARY ********");

        System.out.println("******** FIRST IMPLEMENTATION ********");




        List<Book> bookList = new ArrayList<>();


        bookList.add(new Book("No Longer At Ease", "978-1", 7));
        bookList.add(new Book("Thing Fall Apart", "978-0", 10));
        bookList.add(new Book("Macbeth", "978-0-06-112008-4", 7));
        bookList.add(new Book("Merchant of Venice", "978-0-7432-7356-5", 4));

        Library library = new Library(bookList);


        LibraryService libry = new LibraryServiceImpl(library);
        libry.borrowBookByPriority(List.of(person4,person3, person2, person1),"978-0");
        libry.borrowBookByPriority(List.of(person3, person2),"978-1");

        System.out.println("******* SECOND IMPLEMENTATION *******");


        libry.borrowBookByFifo(List.of(person2,person4, person3, person1),"978-0");
        libry.borrowBookByFifo(List.of(person2,person4, person3, person1),"978-1");


    }
}
