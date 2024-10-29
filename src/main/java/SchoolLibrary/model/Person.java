package SchoolLibrary.model;

import SchoolLibrary.enums.Role;

public abstract class Person {
    private String name;
    private String gender;
    private int age;
    private int id;
    private Role role;

    public Person(String name, String gender, int age, int id, Role role) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
        this.role = role;

    }
    public boolean canBorrow (Book book){
        return book.getCopies() > 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}



