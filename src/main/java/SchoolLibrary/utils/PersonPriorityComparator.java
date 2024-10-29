package SchoolLibrary.utils;

import SchoolLibrary.model.Person;

import java.util.Comparator;

public class PersonPriorityComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getRole().getPriority(),o2.getRole().getPriority());

        }

}

