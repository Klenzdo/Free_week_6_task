package SchoolLibrary.service;

import SchoolLibrary.model.Person;

import java.util.List;

public interface LibraryService {
    void borrowBookByPriority(List<Person> borrowers, String isbn);
    void borrowBookByFifo(List<Person> borrowers, String isbn);

}
