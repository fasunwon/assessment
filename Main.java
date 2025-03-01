import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int numberOfDice = 5;
        int numberOfSimulations = 10000;
        Map<Integer, Integer> scoreCounts = new HashMap<Integer, Integer>();

        long startTime = System.currentTimeMillis();
        for(int i = 0; i<numberOfSimulations; i++){
            DiceSim simulation = new DiceSim(numberOfDice);
            int finalScore = simulation.play();
            scoreCounts.put(finalScore, scoreCounts.getOrDefault(finalScore, 0)+1);
        }
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime-startTime) / 1000.0;
        printStats(numberOfSimulations, scoreCounts, elapsedTime, numberOfDice);
    }

    private static void printStats(int numberOfSimulations, Map<Integer, Integer>scoreCounts, double elapsedTime, int numberOfDice) {
        System.out.println("Number of simulations was " + numberOfSimulations + " using " + numberOfDice + " dice ");
        for(Map.Entry<Integer, Integer> entry : scoreCounts.entrySet()){
            double probability = (double) entry.getValue() / numberOfSimulations;
            System.out.println("Total " + entry.getKey() + " occurs " + probability + " occurred " + (double) entry.getValue() + " times\n ");
        }
        System.out.println("Total simulation took " + elapsedTime + " secs\n");
    }
}
