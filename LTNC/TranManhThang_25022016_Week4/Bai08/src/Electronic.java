public abstract class Electronic {
    protected String id;
    protected String name;
    protected boolean statusOn;

    public Electronic(String id, String name, boolean statusOn) {
        this.id = id;
        this.name = name;
        this.statusOn = statusOn;
    }

    public Electronic(String id, String name) {
        this(id, name, false);
    }

    public void turnOn() {
        statusOn = true;
        System.out.println(name + " turned on");
    }

    public void turnOff() {
        statusOn = false;
        System.out.println(name + " turned off");
    }
}
