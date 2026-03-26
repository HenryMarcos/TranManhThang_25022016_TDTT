public class DataManager implements IData {
    // Cố tình KHÔNG ghi public
    /* 
    void show() { 
        System.out.println("Show Data");
    }
    Lỗi:
    error: show() in DataManager cannot implement show() in IData
    void show() {
         ^
    attempting to assign weaker access privileges; was public

    Giải thích:
    -nếu không ghi public thì hàm sẽ mặc định là default(hoặc package-private)
    -default giới hạn hơn protected và public, nhưng ít giới hạn hơn private
    -hàm show() mặc định là public nên chỉ có thể ghi đè bằng public, nếu dùng key giới hạn
    hơn thì sẽ bị lỗi

    Sửa lại bằng cách thêm public 

    */

    public void show() { 
        System.out.println("Show Data");
    }
}
