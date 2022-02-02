package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;
import com.lukitech.chess.board.Position;

public class Knight extends Piece
{
	public Knight(Color color, Position position){
		super("Knight", color, position);
	}

   @Override
   public String getLetter() {
      return "N";
   }

   @Override
   public List<Direction> getDirections() {
      var directions = new ArrayList<Direction>();
      directions.add(Direction.getDirection( getPosition(),  1, 2, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE | Direction.JUMP_MOVE));
      directions.add(Direction.getDirection( getPosition(),  1, -2, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE | Direction.JUMP_MOVE));
      directions.add(Direction.getDirection( getPosition(),  -1, 2, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE | Direction.JUMP_MOVE));
      directions.add(Direction.getDirection( getPosition(),  -1, -2, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE | Direction.JUMP_MOVE));

      directions.add(Direction.getDirection( getPosition(),  2, 1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE | Direction.JUMP_MOVE));
      directions.add(Direction.getDirection( getPosition(),  2, -1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE | Direction.JUMP_MOVE));
      directions.add(Direction.getDirection( getPosition(),  -2, 1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE | Direction.JUMP_MOVE));
      directions.add(Direction.getDirection( getPosition(),  -2, -1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE | Direction.JUMP_MOVE));

      return directions;
   }
}