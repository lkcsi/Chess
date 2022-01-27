package com.lukitech.chess.pieces;

public class King extends Piece
{
	public King(Color color){
		super("King", color);	
	}

   @Override
   public char getLetter() {
      return 'K';
   }
}