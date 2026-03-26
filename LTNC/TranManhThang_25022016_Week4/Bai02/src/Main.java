public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        if (hero instanceof CanSwim) {
            ((CanSwim) hero).swim();
        }
        hero.fight();
    }
}
