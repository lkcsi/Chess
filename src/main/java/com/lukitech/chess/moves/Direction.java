package com.lukitech.chess.moves;

import com.lukitech.chess.board.Position;

import java.util.ArrayList;
import java.util.List;

public class Direction {
    private ArrayList<Position> positions;

    public Direction(Position position){
        super();
        positions.add(position);
    }

    public Direction(){
        positions = new ArrayList<>();
    }

    public Position get(int index){
        return positions.get(index);
    }

    public void addPosition(Position position){
        positions.add(position);
    }

    public int size(){
        return positions.size();
    }


}
