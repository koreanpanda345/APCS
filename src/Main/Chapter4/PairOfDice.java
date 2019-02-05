package Main.Chapter4;

import java.util.Random;

public class PairOfDice {
    public static Random generator = new Random();
    private int numFaces;
    private int faceValue;
    public PairOfDice(){
        numFaces = 6;
        faceValue = 1;
    }
    public int roll(){
        faceValue = generator.nextInt(numFaces) + 1;
        return faceValue;
    }
    public int getFaceValue(){
        return faceValue;
    }
}
