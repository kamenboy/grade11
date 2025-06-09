import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainApp extends JFrame {
    private Playlist playlist;
    private DefaultListModel<String> listModel;
    private JList<String> songList;
    private JLabel playlistLabel;


    public MainApp() {
        playlist = new Playlist("My Playlist");

        setTitle("Music Playlist Manager");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        songList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(songList);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New Playlist");
        JMenuItem openItem = new JMenuItem("Open Playlist");
        JMenuItem saveItem = new JMenuItem("Save Playlist");


        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        newItem.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter new playlist name:");
            if (name != null && !name.isEmpty()) {
                playlist = new Playlist(name);
                refreshSongList();
                setTitle("Music Playlist Manager - " + name);
            }
        });

        openItem.addActionListener(e -> {
            String filename = JOptionPane.showInputDialog(this, "Enter playlist name to open:");
            if (filename != null && !filename.isEmpty()) {
                File file = new File("data", filename.endsWith(".txt") ? filename : filename + ".txt");
                if (file.exists()) {
                    try {
                        playlist = Playlist.loadFromFile(file);
                        refreshSongList();
                        setTitle("Music Playlist Manager - " + playlist.getName());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Failed to load playlist.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Playlist file not found.");
                }
            }
        });


        saveItem.addActionListener(e -> {
            File file = new File("data", playlist.getName() + ".txt");
            try {
                playlist.saveToFile(file);
                JOptionPane.showMessageDialog(this, "Playlist saved as " + file.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Failed to save playlist.");
            }
        });



        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Song");
        JButton removeButton = new JButton("Remove Song");

        addButton.addActionListener(e -> addSongDialog());
        removeButton.addActionListener(e -> {
            int index = songList.getSelectedIndex();
            if (index != -1) {
                playlist.removeSong(index);
                listModel.remove(index);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        JButton sortTitleButton = new JButton("Sort by Title");
        JButton sortDurationButton = new JButton("Sort by Duration");

        sortTitleButton.addActionListener(e -> {
            playlist.sortByTitle();
            refreshSongList();
        });

        sortDurationButton.addActionListener(e -> {
            playlist.sortByDuration();
            refreshSongList();
        });

        buttonPanel.add(sortTitleButton);
        buttonPanel.add(sortDurationButton);


        playlistLabel = new JLabel("Playlist: " + playlist.getName(), SwingConstants.CENTER);
        add(playlistLabel, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addSongDialog() {
        JTextField titleField = new JTextField(10);
        JTextField artistField = new JTextField(10);
        JTextField durationField = new JTextField(5);
        JTextField genreField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Artist:"));
        panel.add(artistField);
        panel.add(new JLabel("Duration (mm:ss):"));
        panel.add(durationField);
        panel.add(new JLabel("Genre:"));
        panel.add(genreField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add New Song", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText();
                String artist = artistField.getText();
                String[] timeParts = durationField.getText().split(":");
                int minutes = Integer.parseInt(timeParts[0]);
                int seconds = Integer.parseInt(timeParts[1]);
                int totalSeconds = minutes * 60 + seconds;
                String genre = genreField.getText();

                Song song = new Song(title, artist, totalSeconds, genre);
                playlist.addSong(song);
                listModel.addElement(song.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid duration format. Please use mm:ss (e.g., 3:54).");
            }
        }
    }

    private void refreshSongList() {
        listModel.clear();
        playlistLabel.setText("Playlist: " + playlist.getName());
        for (Song song : playlist.getSongs()) {
            listModel.addElement(song.toString());
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
