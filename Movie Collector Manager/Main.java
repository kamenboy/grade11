import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Movie {
    String title;
    String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
}

public class Main extends JFrame {
    private ArrayList<Movie> movies = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTextField titleField, searchField;
    private JComboBox<String> genreBox;
    private JLabel countLabel;
    private JTable movieTable;

    public Main() {
        setTitle("Movie Manager");
        setSize(500, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        JPanel addMoviePanel = new JPanel();
        titleField = new JTextField(10);
        genreBox = new JComboBox<>(new String[]{"Action", "Comedy", "Horror", "Drama"});
        JButton addButton = new JButton("Add");
        addMoviePanel.add(new JLabel("Title:"));
        addMoviePanel.add(titleField);
        addMoviePanel.add(new JLabel("Genre:"));
        addMoviePanel.add(genreBox);
        addMoviePanel.add(addButton);
        inputPanel.add(addMoviePanel);

        JPanel sortPanel = new JPanel();
        JButton sortTitleButton = new JButton("Sort by Title");
        JButton sortGenreButton = new JButton("Sort by Genre");
        sortPanel.add(sortTitleButton);
        sortPanel.add(sortGenreButton);
        inputPanel.add(sortPanel);
        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"Title", "Genre"}, 0);
        movieTable = new JTable(tableModel);
        add(new JScrollPane(movieTable), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        countLabel = new JLabel("Movies: 0");
        bottomPanel.add(countLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel searchPanel = new JPanel();
        searchField = new JTextField(10);
        JButton searchButton = new JButton("Search");
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.AFTER_LAST_LINE);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMovie();
            }
        });

        sortTitleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortMoviesByTitle();
            }
        });

        sortGenreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortMoviesByGenre();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchMovie();
            }
        });
    }

    private void addMovie() {
        String title = titleField.getText().trim();
        String genre = (String) genreBox.getSelectedItem();
        if (!title.isEmpty()) {
            movies.add(new Movie(title, genre));
            tableModel.addRow(new Object[]{title, genre});
            countLabel.setText("Movies: " + movies.size());
            titleField.setText("");
        }
    }

    private void sortMoviesByTitle() {
        int n = movies.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (movies.get(j).title.compareTo(movies.get(j + 1).title) > 0) {
                    Movie temp = movies.get(j);
                    movies.set(j, movies.get(j + 1));
                    movies.set(j + 1, temp);
                }
            }
        }
        updateTable();
    }

    private void sortMoviesByGenre() {
        int n = movies.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (movies.get(j).genre.compareTo(movies.get(j + 1).genre) > 0) {
                    Movie temp = movies.get(j);
                    movies.set(j, movies.get(j + 1));
                    movies.set(j + 1, temp);
                }
            }
        }
        updateTable();
    }

    private void searchMovie() {
        String searchTitle = searchField.getText().trim().toLowerCase();
        if (searchTitle.isEmpty()) {
            return;
        }

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).title.toLowerCase().contains(searchTitle)) {
                movieTable.setRowSelectionInterval(i, i);
                movieTable.scrollRectToVisible(new Rectangle(movieTable.getCellRect(i, 0, true)));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Movie not found!");
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Movie movie : movies) {
            tableModel.addRow(new Object[]{movie.title, movie.genre});
        }
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
