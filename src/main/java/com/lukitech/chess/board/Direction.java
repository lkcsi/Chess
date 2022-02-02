package com.lukitech.chess.board;

import java.util.ArrayList;

public class Direction {
   private ArrayList<Position> positions;
   private int moveFlags;
   public static final int CAPTURE_MOVE = 1;
   public static final int JUMP_MOVE = 2;
   public static final int SIMPLE_MOVE = 4;

   public Direction(int moveFlags){
      positions = new ArrayList<>();
      this.moveFlags = moveFlags;
   }

   public Direction(Position position, int moveFlags){
      positions = new ArrayList<>();
      positions.add(position);
      this.moveFlags = moveFlags;
   }

   public boolean onlyMove(int moveFlags){
      return this.moveFlags == moveFlags;
   }

   public boolean canMove(int moveFlags){
      return (this.moveFlags & moveFlags) == moveFlags;
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

   public static Direction getDirection(Position position, int colStep, int rowStep, int distance, int moveFlags){
      var direction = new Direction(moveFlags);
      int col = position.getColumn() + colStep;
      int row = position.getRow() + rowStep;

      while(col < 9 && row < 9 && col > 0 && row > 0 && direction.size() < distance){
         direction.addPosition(new Position(col, row));         
         col = col + colStep;
         row = row + rowStep;
      }
      return direction;
   }

   public static Direction getDirection(Position position, int colStep, int rowStep, int moveFlags) {
      return getDirection(position, colStep, rowStep, 100, moveFlags);
   }
   public int size() {
      return positions.size();
   }
}
