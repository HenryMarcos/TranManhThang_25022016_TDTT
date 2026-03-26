public class DVD extends MediaItem {
    private String director;
    private int duration;

    public DVD(String id, String name, String director, int duration) {
        super(id, name);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return name + " - " + director + " - " + duration;
    }
}
