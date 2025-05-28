public class Song {
    private String title;
    private String artist;
    private int duration;
    private String genre;

    public Song(String title, String artist, int duration, String genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }
    public String getGenre() { return genre; }

    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setGenre(String genre) { this.genre = genre; }

    public String toString() {
        return title + " - " + artist + " (" + duration + "s)";
    }
}

