import java.util.List;
import java.util.ArrayList;

class Folder extends FileSystemItem {
    private List<FileSystemItem> children; // Danh sách các phần tử con

    public Folder(String name) {
        super(name);
        children = new ArrayList<>();
    }

    // Thêm một phần tử vào thư mục
    public void add(FileSystemItem item) {
        item.setParent(this); // Gán thư mục này làm cha của phần tử được thêm vào
        children.add(item);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        // Duyệt qua các phần tử con và gọi hàm print với indent tăng thêm (2 khoảng trắng)
        for (FileSystemItem child : children) {
            child.print(indent + "  "); 
        }
    }
}