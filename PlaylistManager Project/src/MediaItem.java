public class MediaItem {
    protected String title;
    protected String artist;
    protected int duration; 

    public MediaItem(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getFormattedDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    public String getDetails() {
        return title + " - " + artist + " (" + getFormattedDuration() + ")";
    }
}
