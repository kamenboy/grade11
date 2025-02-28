import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        new GUI();

        Movie[] movies = {
                new Movie("Fast and Furious", "Action"),
                new Movie("Harry Potter", "Fantasy"),
                new Movie("The Wolf of Wall Street", "Comedy/Thriller")
        };

    }
}

class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
