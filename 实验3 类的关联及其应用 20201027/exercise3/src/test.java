public class test {
    public static void main(String[] args){
        Character king = new King();
        king.fight();
        king.fightWithWeapon();
        System.out.println("Change king's weapon:");
        king.setWeapon(new AxeBehavior());
        king.fightWithWeapon();
        Character queen = new Queen();
        queen.fight();
        queen.fightWithWeapon();
        Character knight = new Knight();
        knight.fight();
        knight.fightWithWeapon();
        Character troll = new Troll();
        troll.fight();
        troll.fightWithWeapon();
    }
}
