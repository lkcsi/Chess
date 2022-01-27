package com.lukitech.chess.pieces;

public class Bishop extends Piece{

   public Bishop(Color color) {
      super("Bishop", color);
   }

   @Override
   public char getLetter() {
      return 'B';
   }
   
}
