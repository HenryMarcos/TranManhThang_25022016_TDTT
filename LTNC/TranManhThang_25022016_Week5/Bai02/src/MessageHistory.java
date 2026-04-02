import java.util.Stack;

public class MessageHistory {
    private Stack<Message> stack = new Stack<>();

    // Lưu từng câu vào Stack khi nhân viên gõ
    public void sendMessage(Message msg) {
        stack.push(msg); // Thêm vào đỉnh Stack
        System.out.println("Nhân viên gõ: \"" + msg.getContent() + "\"");
    }

    // Tính năng Undo: Xóa câu gần nhất vừa gõ
    public void undo() {
        if (!stack.isEmpty()) {
            Message removedMsg = stack.pop(); // Lấy và xóa phần tử ở đỉnh Stack
            System.out.println("[Undo] Đã xóa tin nhắn: \"" + removedMsg.getContent() + "\"");
        } else {
            System.out.println("[Undo] Lịch sử tin nhắn đang trống, không thể Undo.");
        }
    }

    // Tính năng View Last: Xem lại câu vừa gõ mà không xóa
    public void viewLast() {
        if (!stack.isEmpty()) {
            Message lastMsg = stack.peek(); // Lấy phần tử ở đỉnh Stack nhưng không xóa
            System.out.println("[View Last] Tin nhắn gần nhất là: \"" + lastMsg.getContent() + "\"");
        } else {
            System.out.println("[View Last] Lịch sử tin nhắn trống.");
        }
    }
}
