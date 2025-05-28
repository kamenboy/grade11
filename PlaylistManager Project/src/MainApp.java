
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainApp extends JFrame {
    private Playlist playlist;
    private DefaultListModel<String> listModel;
    private JList<String> songList;

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

        add(new JLabel("Playlist: " + playlist.getName(), SwingConstants.CENTER), BorderLayout.NORTH);
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


    public static void main(String[] args) {
        new MainApp();
    }
}
