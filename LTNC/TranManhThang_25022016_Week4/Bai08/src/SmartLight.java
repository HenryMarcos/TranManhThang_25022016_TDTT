public class SmartLight extends Electronic implements AdjustableLevel {
    static private final int maxLightLevel = 100;
    private int lightLevel;

    public SmartLight(String id, String name, boolean statusOn, int lightLevel) {
        super(id, name, statusOn);
        this.lightLevel = lightLevel;
    }

    public SmartLight(String id, String name) {
        super(id, name);
        this.lightLevel = 0;
    }

    @Override
    public void increaseLevel() {
        lightLevel += 1;
        if (lightLevel > maxLightLevel) {
            lightLevel = maxLightLevel;
        }
    }

    @Override
    public void decreaseLevel() {
        lightLevel -= 1;
        if (lightLevel < 0) {
            lightLevel = 0;
        }
    }
}
