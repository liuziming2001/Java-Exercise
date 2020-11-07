public abstract class Character {
    WeaponBehavior weapon;
    public void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }
    public abstract void fight();
    public void fightWithWeapon(){
        weapon.useWeapon();
    }
}
