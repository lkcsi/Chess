package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;
import com.lukitech.chess.board.Position;

public class King extends Piece implements CheckMateable, Ruler{

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
   public boolean inCheck() {
      //
      return false;
   }

   @Override
   public boolean giveCheck() {
      return false;
   }

   @Override
   public List<Direction> getDirections() {
      
      var directions = new ArrayList<>();
      directions.add(getDirection(-1, -1));
      directions.add(getDirection(-1,  1));
      directions.add(getDirection( 1, -1));
      directions.add(getDirection( 1,  1));
      directions.add(getDirection(-1,  0));
      directions.add(getDirection( 1,  0));
      directions.add(getDirection( 0, -1));
      directions.add(getDirection( 0,  1));
      
      return null;
   }

   private Direction getDirection(int x, int y){

      var position = getPosition();
      var direction = new Direction();
      
      try{ direction.addPosition(new Position(position.getColumn() + x, position.getRow() + y));}
      catch(Exception e){}

      return direction;
   }
}
