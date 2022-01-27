package com.lukitech.chess.pieces;

public class Pawn extends Piece {

   public Pawn(Color color) {
      super("Pawn", color);
   }

   @Override
   public char getLetter() {
      return 'P';
   }
   
}
