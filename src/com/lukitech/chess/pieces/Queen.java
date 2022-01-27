package com.lukitech.chess.pieces;

public class Queen extends Piece {

   public Queen(Color color) {
      super("Queen", color);      
   }

   @Override
   public char getLetter() {
      return 'Q';
   }
   
}
