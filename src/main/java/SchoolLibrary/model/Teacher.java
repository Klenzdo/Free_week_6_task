package SchoolLibrary.model;

import SchoolLibrary.enums.Role;

public class Teacher extends Person {
    public Teacher(String name, String gender, int age, int id) {
        super(name, gender, age, id, Role.TEACHER);
    }


}
