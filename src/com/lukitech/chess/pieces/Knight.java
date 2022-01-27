package com.lukitech.chess.pieces;

public class Knight extends Piece
{
	public Knight(Color color){
		super("Knight", color);	
	}

   @Override
   public char getLetter() {
      return 'N';
   }
}