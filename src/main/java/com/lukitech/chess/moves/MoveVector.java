package com.lukitech.chess.moves;

import com.lukitech.chess.pieces.Color;

public class MoveVector {
    private int colStep;
    private int rowStep;
    private int min;
    private int max;
    private Color color;
    private boolean capture;

    public MoveVector(){
    }

    public int getColStep() {
        return colStep;
    }

    public int getRowStep() {
        return rowStep;
    }

    public int getMin() {
        return min;
    }

    public void setColStep(int colStep) {
        this.colStep = colStep;
    }

    public void setRowStep(int rowStep) {
        this.rowStep = rowStep;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }
}
