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
   }

   public void setCaptureDirection(boolean capture){
      this.capture = capture;
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

   public static Direction getLongDirection(Position position, int colStep, int rowStep){
      var direction = new Direction();
      int col = position.getColumn() + colStep;
      int row = position.getRow() + rowStep;

      while(col < 9 && row < 9 && col > 0 && row > 0){
         direction.addPosition(new Position(col, row));         
         col = col + colStep;
         row = row + rowStep;
      }
      return direction;
   }

   public static Direction getStepDirection(Position position, int colStep, int rowStep, boolean capture){
      var direction = getStepDirection(position, colStep, rowStep);
      direction.setCaptureDirection(true);
      return direction;
   }

   public static Direction getStepDirection(Position position, int colStep, int rowStep){
      var direction = new Direction();
      int col = position.getColumn() + colStep;
      int row = position.getRow() + rowStep;

      if(col < 9 && row < 9 && col > 0 && row > 0){
         direction.addPosition(new Position(col, row));
      }
      return direction;
   }
}
