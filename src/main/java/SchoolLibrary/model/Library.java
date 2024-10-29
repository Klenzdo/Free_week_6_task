package SchoolLibrary.model;

import SchoolLibrary.utils.PersonPriorityComparator;

import java.util.List;
import java.util.PriorityQueue;

import static java.util.Comparator.comparing;

public class Library {
    private List<Book> collection;

    public Library(List<Book> collection) {
        this.collection = collection;
    }

    public List<Book> getCollection() {
        return collection;
    }
}
















//
//    PriorityQueue<Person> queue = new PriorityQueue<>(new PersonPriorityComparator());
//    PriorityQueue<Person> queue1 = new PriorityQueue<>((t1, t2)->Integer.compare(t1.getRole().getPriority(), t2.getRole().getPriority()));
//    PriorityQueue<Person> queue2 = new PriorityQueue<>(comparing(p-> p.getRole().getPriority()));

//}
