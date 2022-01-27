package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;

public class Queen extends Piece {

   public Queen(Color color) {
      super("Queen", color);      
   }

   @Override
   public char getLetter() {
      return 'Q';
   }
   

   @Override
   public boolean isLegalMove(Position position) {
      if(position.equals(getPosition()))
         return false;

      return true;
   }

}
