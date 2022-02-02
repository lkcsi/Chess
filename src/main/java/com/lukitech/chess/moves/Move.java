package com.lukitech.chess.moves;

import com.lukitech.chess.board.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

public class Move {
   private ArrayList<Position> positions;
   private EnumSet<MoveType> moveTypes;

   public Move(EnumSet<MoveType> moveTypes){
      positions = new ArrayList<>();
      this.moveTypes = EnumSet.noneOf(MoveType.class);
      this.moveTypes.addAll(moveTypes);
   }

   public Move(Position position, EnumSet<MoveType> moveTypes){
      this(moveTypes);
      positions.add(position);
   }

   public EnumSet<MoveType> moveTypes(){
      return moveTypes;
   }

   public void addPosition(Position position){
      positions.add(position);
   }
   public ArrayList<Position> getPositions(){
      return positions;
   }
   public boolean contains(Position position){
      return positions.stream().anyMatch(p -> p.equals(position));
   }
   public int size() {
      return positions.size();
   }
}
