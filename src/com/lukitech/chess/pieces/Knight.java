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
   public MoveResult move(Position newPosition) {
      if(newPosition.equals(getPosition()))
         return new MoveResult(false, "Not a move");

      int deltaRow = Math.abs(this.getPosition().getRow() - newPosition.getRow());
      int deltaCol = Math.abs(this.getPosition().getColumn() - newPosition.getColumn()); 

      if(!((deltaCol == 1 && deltaRow == 2) || (deltaRow == 1 && deltaCol == 2)))
         return new MoveResult(false, "Not a valid move");

      //Check if king was in check after move

      var piece = getBoard().getPieces().stream().filter(p -> p.getPosition().equals(newPosition)).findFirst();
      if(piece.isPresent())
      {
         if(piece.get() instanceof CheckMateable)
            return new MoveResult(false, "Cannot capture this piece");
         
         piece.get().captured();
         return new MoveResult(true, "Capture");
      }

      return super.move(newPosition);
   }
}