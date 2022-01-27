package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;

public class King extends Piece
{
	public King(Color color){
		super("King", color);	
	}

   @Override
   public char getLetter() {
      return 'K';
   }

   @Override
   public boolean isLegalMove(Position position) {
      if(position.equals(getPosition()))
         return false;

      int deltaRow = Math.abs(this.getPosition().getRow() - position.getRow());
      int deltaCol = Math.abs(this.getPosition().getColumn() - position.getColumn()); 

      if(deltaCol > 1 || deltaRow > 1)
         return false;

      return true;
   }
}