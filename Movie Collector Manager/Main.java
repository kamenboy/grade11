import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Comparator;

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

public class Main extends JFrame {
    private ArrayList<Movie> movies = new ArrayList<>();
    private JTable movieTable;
    private DefaultTableModel tableModel;
    private JTextField titleField, searchField;
    private JComboBox<String> genreBox;
    private JLabel countLabel;

    public Main() {
        setTitle("Movie Collection Manager");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Top panel for input and search
        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        JPanel addPanel = new JPanel(new FlowLayout());
        titleField = new JTextField(15);
        genreBox = new JComboBox<>(new String[]{"Action", "Comedy", "Horror", "Drama"});
        JButton addButton = new JButton("Add Movie");
        addPanel.add(new JLabel("Title:"));
        addPanel.add(titleField);
        addPanel.add(new JLabel("Genre:"));
        addPanel.add(genreBox);
        addPanel.add(addButton);
        inputPanel.add(addPanel);

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(15);
        JButton searchButton = new JButton("Search");
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        inputPanel.add(searchPanel);
        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"Title", "Genre"}, 0);
        movieTable = new JTable(tableModel);
        add(new JScrollPane(movieTable), BorderLayout.CENTER);

        JPanel actionPanel = new JPanel(new FlowLayout());
        JButton sortTitleButton = new JButton("Sort by Title");
        JButton sortGenreButton = new JButton("Sort by Genre");
        countLabel = new JLabel("Total Movies: 0");
        actionPanel.add(sortTitleButton);
        actionPanel.add(sortGenreButton);
        actionPanel.add(countLabel);
        add(actionPanel, BorderLayout.SOUTH);
        addButton.addActionListener(e -> addMovie());
        sortTitleButton.addActionListener(e -> sortMoviesByTitle());
        sortGenreButton.addActionListener(e -> sortMoviesByGenre());
        searchButton.addActionListener(e -> searchMovie());
    }

    private void addMovie() {
        String title = titleField.getText().trim();
        String genre = (String) genreBox.getSelectedItem();
        if (!title.isEmpty()) {
            movies.add(new Movie(title, genre));
            updateTable();
            titleField.setText("");
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Movie movie : movies) {
            tableModel.addRow(new Object[]{movie.getTitle(), movie.getGenre()});
        }
        countLabel.setText("Total Movies: " + movies.size());
    }

    private void sortMoviesByTitle() {
        movies.sort(Comparator.comparing(Movie::getTitle));
        updateTable();
    }

    private void sortMoviesByGenre() {
        movies.sort(Comparator.comparing(Movie::getGenre));
        updateTable();
    }

    private void searchMovie() {
        String searchTitle = searchField.getText().trim().toLowerCase();
        if (searchTitle.isEmpty()) return;

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().toLowerCase().contains(searchTitle)) {
                movieTable.setRowSelectionInterval(i, i);
                movieTable.scrollRectToVisible(new Rectangle(movieTable.getCellRect(i, 0, true)));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Movie not found!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
