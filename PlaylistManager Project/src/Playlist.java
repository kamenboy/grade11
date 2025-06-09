import java.io.*;
import java.util.*;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getName() { return name; }
    public ArrayList<Song> getSongs() { return songs; }

    public void addSong(Song song) { songs.add(song); }
    public void removeSong(int index) {
        if (index >= 0 && index < songs.size()) songs.remove(index);
    }

    public void sortByTitle() {
        songs.sort(Comparator.comparing(Song::getTitle));
    }

    public void sortByDuration() {
        songs.sort(Comparator.comparingInt(Song::getDuration));
    }

    public void saveToFile(File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(name);
            writer.newLine();
            for (Song song : songs) {
                writer.write(song.getTitle() + ";" + song.getArtist() + ";" + song.getDuration() + ";" + song.getGenre());
                writer.newLine();
            }
        }
    }

    public static Playlist loadFromFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String name = reader.readLine();
            Playlist playlist = new Playlist(name);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    String title = parts[0];
                    String artist = parts[1];
                    int duration = Integer.parseInt(parts[2]);
                    String genre = parts[3];
                    playlist.addSong(new Song(title, artist, duration, genre));
                }
            }
            return playlist;
        }
    }
}
