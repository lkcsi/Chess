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
   public MoveResult move(Position newPosition) {
      if(newPosition.equals(getPosition()))
         return new MoveResult(false, "Not move");

      return super.move(newPosition);
   }
   
}
