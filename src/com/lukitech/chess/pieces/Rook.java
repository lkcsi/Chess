package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;

public class Rook extends Piece {

   public Rook(Color color) {
      super("R", color);
   }

   @Override
   public char getLetter() {
      return 'R';
   }
   
   @Override
   public boolean isLegalMove(Position position) {
      if(position.equals(getPosition()))
         return false;

      return true;
   }

}
