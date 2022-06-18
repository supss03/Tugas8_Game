package game;

public class Warrior extends Character{
    Warrior(){
        setHP(80);
        setAttack(25);
        setDefense(30);
    }

    @Override
    public boolean attack() {
        double counter = Math.random() * 10;
        return counter > 0 && counter <= 6.0;
    }
}