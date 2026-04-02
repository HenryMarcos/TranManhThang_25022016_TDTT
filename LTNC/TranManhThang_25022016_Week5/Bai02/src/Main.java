public class Main {
    public static void main(String[] args) {
        CustomerQueue customerQueue = new CustomerQueue();
        MessageHistory messageHistory = new MessageHistory();

        // Tạo dữ liệu khách hàng
        Customer khachA = new Customer("1", "Khách A");
        Customer khachB = new Customer("2", "Khách B");

        System.out.println("--- GIAI ĐOẠN 1: KHÁCH HÀNG ĐẾN ---");
        customerQueue.addCustomer(khachA); // Khách A đến
        customerQueue.addCustomer(khachB); // Khách B đến

        System.out.println("\n--- GIAI ĐOẠN 2: XỬ LÝ KHÁCH A ---");
        customerQueue.processCustomer();
        
        // Gõ 3 dòng tin nhắn
        messageHistory.sendMessage(new Message("101", "Dạ chào anh/chị."));
        messageHistory.sendMessage(new Message("102", "Anh/chị cần hỗ trợ vấn đề gì ạ?"));
        messageHistory.sendMessage(new Message("103", "Vui lòng đợi em một chút nhé.")); // Gõ sai hoặc dư
        
        // View Last thử
        messageHistory.viewLast();
        
        // Undo 1 dòng
        messageHistory.undo();

        System.out.println("\n--- GIAI ĐOẠN 3: XỬ LÝ KHÁCH B ---");
        customerQueue.processCustomer();
        messageHistory.sendMessage(new Message("104", "Chào Khách B, mã đơn hàng của bạn đã được ghi nhận."));

        System.out.println("\n--- GIAI ĐOẠN 4: HÀNG ĐỢI RỖNG ---");
        // Bấm xử lý khi không còn ai
        customerQueue.processCustomer();
    }
}
