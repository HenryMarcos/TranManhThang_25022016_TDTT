public class SmartSpeaker extends Electronic implements AdjustableLevel, Wifi {
    static private final int maxSoundVolume = 100;
    private int soundVolume;

    public SmartSpeaker(String id, String name, boolean statusOn, int soundVolume) {
        super(id, name, statusOn);
        this.soundVolume = soundVolume;
    }

    public SmartSpeaker(String id, String name) {
        super(id, name);
    }

    @Override
    public void increaseLevel() {
        soundVolume += 1;
        if (soundVolume > maxSoundVolume) {
            soundVolume = maxSoundVolume;
        }
    }

    @Override
    public void decreaseLevel() {
        soundVolume -= 1;
        if (soundVolume < 0) {
            soundVolume = 0;
        }
    }

    @Override
    public void setupWifi() {
        System.out.println(name + " connected to wifi");
    }
}
