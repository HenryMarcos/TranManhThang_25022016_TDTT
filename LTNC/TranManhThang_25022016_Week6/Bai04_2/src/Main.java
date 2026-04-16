public class Main {
    public static void main(String[] args) {
        // Tạo các đối tượng cụ thể (Low-level modules)
        AudioPlayable myAudioPlayer = new AudioPlayer();
        VideoPlayable myVideoPlayer = new VideoPlayer();

        // Tiêm (Inject) các dependencies này vào MediaPlayer (High-level module)
        System.out.println("--- Khởi động MediaPlayer ---");
        MediaPlayer player = new MediaPlayer(myAudioPlayer, myVideoPlayer);

        // Gọi các phương thức phát media
        player.playAudio("bai_hat_hay_nhat.mp3");
        player.playVideo("phim_hanh_dong.mp4");
    }
}
