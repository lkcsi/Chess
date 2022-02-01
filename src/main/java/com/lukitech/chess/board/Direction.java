package com.lukitech.chess.board;

import java.util.ArrayList;

public class Direction {
   public ArrayList<Position> positions;
   public boolean capture;

   public Direction(){
      positions = new ArrayList<>();
      capture = true;
   }

   public Direction(Position position){
      positions = new ArrayList<>();
      positions.add(position);
      capture = true;
   }

   public Direction setCaptureDirection(boolean capture){
      this.capture = capture;
      return this;
   }

   public boolean captureDirection(){
      return capture;
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

   public static Direction getDirection(Position position, int colStep, int rowStep, int distance){
      var direction = new Direction();
      int col = position.getColumn() + colStep;
      int row = position.getRow() + rowStep;

      while(col < 9 && row < 9 && col > 0 && row > 0 && direction.size() < distance){
         direction.addPosition(new Position(col, row));         
         col = col + colStep;
         row = row + rowStep;
      }
      return direction;
   }

   public static Direction getDirection(Position position, int colStep, int rowStep) {
      return getDirection(position, colStep, rowStep, 100);
   }
   public int size() {
      return positions.size();
   }
}
