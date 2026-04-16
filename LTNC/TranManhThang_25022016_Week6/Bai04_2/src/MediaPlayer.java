class MediaPlayer {
    private AudioPlayable audioPlayer;
    private VideoPlayable videoPlayer;

    // Dependency Injection thông qua Constructor
    // Không sử dụng từ khóa 'new' ở đây để tránh bị coupling (kết dính chặt)
    public MediaPlayer(AudioPlayable audio, VideoPlayable video) {
        this.audioPlayer = audio;
        this.videoPlayer = video;
    }

    // Các hàm ủy quyền (delegate) gọi xuống các component tương ứng
    public void playAudio(String file) {
        if (audioPlayer != null) {
            audioPlayer.playAudio(file);
        } else {
            System.out.println("Hệ thống không hỗ trợ phát âm thanh.");
        }
    }

    public void playVideo(String file) {
        if (videoPlayer != null) {
            videoPlayer.playVideo(file);
        } else {
            System.out.println("Hệ thống không hỗ trợ phát video.");
        }
    }
}