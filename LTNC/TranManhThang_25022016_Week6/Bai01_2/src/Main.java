public class Main {
    public static void main(String[] args) {
        // Tạo thư mục gốc
        Folder root = new Folder("root");
        
        // Tạo thư mục con 'docs'
        Folder docs = new Folder("docs");
        
        // Tạo các file bên trong 'docs'
        FileItem aTxt = new FileItem("a.txt", 12);
        FileItem bTxt = new FileItem("b.txt", 8);
        
        // Tạo shortcut trỏ tới file 'a.txt'
        Shortcut aShortcut = new Shortcut("a-shortcut", aTxt);
        
        // Thêm file và shortcut vào thư mục 'docs'
        docs.add(aTxt);
        docs.add(bTxt);
        docs.add(aShortcut);
        
        // Tạo file ngang hàng với 'docs'
        FileItem readme = new FileItem("readme.md", 4);
        
        // Thêm 'docs' và 'readme.md' vào thư mục gốc 'root'
        root.add(docs);
        root.add(readme);
        
        // Bắt đầu in toàn bộ cây thư mục với chuỗi thụt lề ban đầu là rỗng
        root.print("");
    }
}