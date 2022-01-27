package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;

public class Knight extends Piece
{
	public Knight(Color color){
		super("Knight", color);	
	}

   @Override
   public char getLetter() {
      return 'N';
   }

   @Override
   public boolean isLegalMove(Position position) {
      if(position.equals(getPosition()))
         return false;

      int deltaRow = Math.abs(this.getPosition().getRow() - position.getRow());
      int deltaCol = Math.abs(this.getPosition().getColumn() - position.getColumn()); 

      if((deltaCol == 1 && deltaRow == 2) || (deltaRow == 1 && deltaCol == 2))
         return true;

      return false;
   }
}