import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiceSim {
    public List<Dice> diceList;
    private final int numberOfDice;
    private int totalScore;
    public DiceSim(int numberOfDice){
        this.numberOfDice = numberOfDice;
        initializeDiceList();
        this.totalScore=0;
    }

    private void initializeDiceList(){ 
        diceList = new ArrayList<Dice>();
        for(int i=0; i<numberOfDice; i++){
            diceList.add(new Dice());
        }
    }

    public int play(){
        while(!diceList.isEmpty()){
            diceList.forEach(Dice::rollDice);
            if(diceListHasThree()){
                removeThreesFromDiceList();
            }else{
                totalScore+=removeLowestDice();
            }
        }
        return totalScore;
    }

    private boolean diceListHasThree(){
        return diceList.stream().anyMatch(dice->dice.getDiceValue() == 3);
    }

    private void removeThreesFromDiceList(){
        diceList.removeIf(dice->dice.getDiceValue() == 3);
    }

    private int removeLowestDice(){
        Dice lowestDice = diceList.stream().min(Comparator.comparingInt(Dice::getDiceValue)).orElse(null);
        if(lowestDice!=null){
            diceList.remove(lowestDice);
            return lowestDice.getDiceValue();
        }
        return 0;
    }
}
