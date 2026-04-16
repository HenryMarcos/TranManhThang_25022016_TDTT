abstract class FileSystemItem {
    protected String name;
    
    // Lưu trữ tham chiếu đến thư mục cha để có thể truy xuất đường dẫn tuyệt đối (dành cho Shortcut)
    protected Folder parent; 

    public FileSystemItem(String name) {
        this.name = name;
    }

    // Phương thức thiết lập thư mục cha
    public void setParent(Folder parent) {
        this.parent = parent;
    }

    // Phương thức đệ quy để lấy đường dẫn tuyệt đối (VD: /root/docs/a.txt)
    public String getPath() {
        if (parent == null) {
            return "/" + name; // Nếu không có cha, nó là gốc
        } else {
            return parent.getPath() + "/" + name; // Ghép đường dẫn của cha với tên của nó
        }
    }

    // Phương thức in trừu tượng mà các lớp con phải tự cài đặt
    public abstract void print(String indent);
}