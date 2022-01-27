package com.lukitech.chess.pieces;

public class Rook extends Piece {

   public Rook(Color color) {
      super("R", color);
   }

   @Override
   public char getLetter() {
      return 'R';
   }
   
}
