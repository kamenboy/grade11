public class libraryTask2 {
    public static void main(String[] args) {
        Book b1 = new Book("Harry Potter & the Philosopher's Stone", "J.K.Rowling", 356);
        Book b2 = new Book("The Stranger", "Albert Camus", 112);
        Book b3 = new Book("In Cold Blood", "Truman Capote", 412);
        // Task 4: Create two or more Book objects with different attributes.
        // Task 5: Call the displayDetails method for each object.
        b1.print();
        b2.print();
        b3.print();
    }
}

// Define the Book class
class Book {
    // Task 1: Add three attributes: title, author, and numberOfPages.
    private String title;
    private String author;
    private int numberOfPages;

    // Constructor
    public Book(String newTitle, String newAuthor, int newNumberOfPages) {
        // Task 2: Initialize the attributes inside this constructor.
        title = newTitle;
        author = newAuthor;
        numberOfPages = newNumberOfPages;
    }

    // Task 3: Add a method displayDetails() to print the book's details (title, author, and numberOfPages).
    public void print(){
        System.out.println("\nBook Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + numberOfPages);
    }
}
