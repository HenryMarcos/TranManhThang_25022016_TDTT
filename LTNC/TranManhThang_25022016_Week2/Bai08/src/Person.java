public class Person {
    private String name;
    private Person me;

    public Person(String name, Person me) {
        this.name = name;
        this.me = me;
    }

    public Person(String name) {
        this(name, null);
    }

    void setMe(Person other) {
        this.me = other;
    }

    public Person getMe() {
        return me;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Person p = new Person("Henry");
        p.setMe(p);
        System.out.println(p.getMe().getName());
    }
}
