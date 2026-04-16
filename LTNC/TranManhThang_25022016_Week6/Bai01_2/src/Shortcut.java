class Shortcut extends FileSystemItem {
    private FileSystemItem target; // Tham chiếu tới phần tử gốc

    public Shortcut(String name, FileSystemItem target) {
        super(name);
        this.target = target;
    }

    @Override
    public void print(String indent) {
        // Sử dụng phương thức getPath() của target để in ra đường dẫn
        System.out.println(indent + "Shortcut: " + name + " -> " + target.getPath());
    }
}