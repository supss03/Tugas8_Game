package game;

public class Titan extends Character{
    Titan(){
        setHP(200);
        setAttack(45);
        setDefense(0);
    }

    @Override
    public boolean attack() {
        double counter = Math.random() * 10;
        return counter > 0 && counter <= 4.0;
    }
}