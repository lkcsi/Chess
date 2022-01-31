package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Direction;

public class Pawn extends Piece {

   private boolean enPassant;

   public Pawn(Color color) {
      super("Pawn", color);
      enPassant = false;
   }

   public boolean enPassantAvailable(){
      return enPassant;
   }

   @Override
   public char getLetter() {
      return 'P';
   }

   @Override
   public List<Direction> getDirections() {
      var directions = new ArrayList<Direction>();
      int row = getPosition().getRow();
      int dir = getColor() == Color.BLACK ? -1 : 1;

      if((Color.BLACK == getColor() && row == 7) || Color.WHITE == getColor() && row == 2){
         directions.add(Direction.getStepDirection(getPosition(), 0, 2 * dir, false));
      }
      directions.add(Direction.getStepDirection(getPosition(),  0, 1 * dir, false));
  
      var capruteDirection = Direction.getStepDirection(getPosition(),  1, 1 * dir);
      if(validityCheck(capruteDirection, getBoard()))
         directions.add(capruteDirection);

      capruteDirection = Direction.getStepDirection(getPosition(), -1, 1 * dir);
      if(validityCheck(capruteDirection, getBoard()))
         directions.add(capruteDirection);
      
      return directions;
   }

   private static boolean validityCheck(Direction direction, Board board){
      if(!direction.getPositions().isEmpty() && board.getPieceByPosition(direction.getPositions().get(0)) != null)
         return true;
      return false;
   }
}
