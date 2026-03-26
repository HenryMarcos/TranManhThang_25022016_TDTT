import java.util.ArrayList;
import java.util.List;

public class LibrarySection<T extends MediaItem> {
    private List<T> mediaItems;

    public LibrarySection() {
        this.mediaItems = new ArrayList<>();
    }

    public void addMedia(T media) {
        mediaItems.add(media);
    }

    public void removeMedia(T media) {
        mediaItems.remove(media);
    }

    public void showInventoryInfo() {
        for (int i = 0; i < mediaItems.size(); i++) {
            System.out.println(mediaItems.get(i));
        }
    }
}
