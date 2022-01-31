package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;
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
   public List<Direction> getDirections() {
      var directions = new ArrayList<Direction>();
      directions.add(getDirection( 1,  2));
      directions.add(getDirection(-1,  2));
      directions.add(getDirection( 1, -2));
      directions.add(getDirection(-1, -2));

      directions.add(getDirection( 2,  1));
      directions.add(getDirection(-2,  1));
      directions.add(getDirection( 2, -1));
      directions.add(getDirection(-2, -1));

      return directions;
   }

   private Direction getDirection(int x, int y){
      var direction = new Direction();
      int col = getPosition().getColumn() + x;
      int row = getPosition().getRow() + y;
      
      if(row < 9 && row > 0 && col < 9 && col > 0)
         direction.addPosition(new Position(row, col));

      return direction;
   }

}