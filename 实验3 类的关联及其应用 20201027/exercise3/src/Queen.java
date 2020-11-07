public class Queen extends Character {
    public Queen() {
        weapon = new AxeBehavior();
    }
    public void fight() {
        System.out.println("queen is fighting...");
    }
}
