package com.lukitech.chess.moves;

public class MoveVector {
    private int colStep;
    private int rowStep;
    private int stepCount;

    public MoveVector(int colStep, int rowStep, int stepCount){
        this.colStep = colStep;
        this.rowStep = rowStep;
        this.stepCount = stepCount;
    }

    public int getColStep() {
        return colStep;
    }

    public int getRowStep() {
        return rowStep;
    }

    public int getStepCount() {
        return stepCount;
    }
}
