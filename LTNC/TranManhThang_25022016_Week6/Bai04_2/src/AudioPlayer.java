class AudioPlayer implements AudioPlayable {
    @Override
    public void playAudio(String file) {
        System.out.println("Đang phát âm thanh: " + file);
    }
}