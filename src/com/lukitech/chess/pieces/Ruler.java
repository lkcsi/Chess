package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;

public class King extends Piece implements CheckMateable
{
	public King(Color color){
		super("King", color);	
	}

   @Override
   public char getLetter() {
      return 'K';
   }

   @Override
   public MoveResult move(Position newPosition) {
      if(newPosition.equals(getPosition()))
         return new MoveResult(false, "Not a move");

      int deltaRow = Math.abs(getPosition().getRow() - newPosition.getRow());
      int deltaCol = Math.abs(getPosition().getColumn() - newPosition.getColumn()); 

      if(deltaCol > 1 || deltaRow > 1)
         return new MoveResult(false, "Invalid move");  

      return super.move(newPosition);
   }

   @Override
   public boolean inCheckMate() {
      return false;
   }

   @Override
   public boolean inCheck(Piece piece) {

      return false;
   }

}