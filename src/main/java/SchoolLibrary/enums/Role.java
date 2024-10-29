package SchoolLibrary.enums;

public enum Role {
    SENIOR_STUDENT(2),

    JUNIOR_STUDENT(3),
    TEACHER(1);

    final int priority;
    Role (int priority){
        this.priority=priority;
    }

    public int getPriority() {
        return priority;
    }
}
