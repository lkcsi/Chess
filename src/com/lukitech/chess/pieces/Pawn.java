package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;

public class Pawn extends Piece {

   public Pawn(Color color) {
      super("Pawn", color);
   }

   @Override
   public char getLetter() {
      return 'P';
   }

   @Override
   public boolean isLegalMove(Position position) {
      if(position.equals(getPosition()))
         return false;

      return true;
   }
   
}
