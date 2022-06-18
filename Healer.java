package game;

public class Healer extends Character{
    Healer(){
        setHP(70);
        setAttack(10);
        setDefense(10);
    }

    void heal(){
        setHP(getHP() + 25);
    }

    @Override
    public boolean attack() {
        double counter = Math.random() * 10;
        return counter > 0 && counter <= 8.5;
    }
}