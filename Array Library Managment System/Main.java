import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Book[] books = {
                new Book("Harry Potter", "J.K.Rowling", 1997, null),
                new Book("The Alchemist", "Paulo Coehlo", 1988, null),
                new Book("The Da Vinci Code", " Dan Brown", 2003, "Bogdan Nakov")
        };
        displayLibrary(books);
        borrowBookMethod(books, scan);
        returnBook(books, "the da vinci code");

        if (findBookByTitle(books, "Harry Potter") != 0) {
            System.out.println("The index of the book Harry Potter is: " + findBookByTitle(books, "Harry Potter"));
        } else {
            System.out.println("Book isn't in our database");
        }

        System.out.println("\nUpdating info on book 2...");
        books[2].updateBookInfo("the da vinci code", "dan brown", 2025);
        System.out.println("Updated Info on Book 2: ");
        books[2].getBookDetails();

        displayLibrary(books);
    }

    public static void displayLibrary(Book[] books) {
        System.out.println("\n                        -----Current Inventory-----");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getBookDetails());
        }
    }

    public static void borrowBookMethod(Book[] books, Scanner scan) {
        System.out.println("\nWhich book do you want to borrow?[1-3]: ");
        int bookRequested = scan.nextInt();
        scan.nextLine();
        System.out.println("What is your name?: ");
        String name = scan.nextLine();
        books[bookRequested - 1].borrowerName(name);
        System.out.println("Book borrowed successfully! \n");
    }

    public static void returnBook(Book[] books, String searchTitle) {
        boolean successfull = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(searchTitle)) {
                books[i].returnBook();
                successfull = true;
            } else if (searchTitle == null || searchTitle.equalsIgnoreCase("")) {
                System.out.println("No name entered.\n");
            }
        }
        if (!successfull) {
            System.out.println("No such book exists.\n");
        }else{
            System.out.println("Book returned successfully! \n");
        }
    }

    public static int findBookByTitle(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return i + 1;
            }
        }
        return 0;
    }
}

class Book {
    private String title;
    private String author;
    private int yearPublished;
    private String borrowerName;

    public Book(String title, String author, int yearPublished, String borrowerName) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.borrowerName = borrowerName;
    }

    public String getBookDetails() {
        return ("Title: " + title + "| Author: " + author + "| Year Published: " + yearPublished + "| Borrower Name: " + borrowerName);
    }

    public void updateBookInfo(String newTitle, String newAuthor, int newYearPublished) {
        this.title = newTitle;
        this.author = newAuthor;
        this.yearPublished = newYearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void borrowerName(String newBorrowerName) {
        this.borrowerName = newBorrowerName;
    }

    public void returnBook() {
        this.borrowerName = null;
    }

    public String borrowerName() {
        return borrowerName;
    }
}
