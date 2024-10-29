package SchoolLibrary.model;

public class Book {
    private String title;
    private String isbn;
    private int copies;


    public Book(String title, String isbn, int copies){
        this.title = title;
        this.isbn = isbn;
        this.copies = copies;

    }

    public String getTitle() {
        return title;
    }


    public String getIsbn() {
        return isbn;
    }


    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
