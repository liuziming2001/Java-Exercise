public class Troll extends Character {
    public Troll() {
        weapon = new BowAndArrowBehavior();
    }
    public void fight() {
        System.out.println("troll is fighting...");
    }
}
