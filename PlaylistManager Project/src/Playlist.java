import java.util.ArrayList;

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
}

