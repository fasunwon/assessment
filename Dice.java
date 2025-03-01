import java.util.Random;

public class Dice{
    private int numberOfFaces = 6;
    private int diceValue;
    public Dice(){
    }
    public Dice(int numberOfFaces){
        this.numberOfFaces = numberOfFaces;
    }
    public void rollDice(){
      this.diceValue = new Random().nextInt(numberOfFaces)+1;
    }

    public int getDiceValue(){
        return this.diceValue;
    }
}