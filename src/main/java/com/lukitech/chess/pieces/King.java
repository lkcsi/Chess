package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;
import com.lukitech.chess.board.Position;

public class King extends Piece implements CheckMateable, Ruler{

   public King(Color color, Position position){
		super("King", color, position);
	}

   @Override
   public String getLetter() {
      return "K";
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
   public List<Direction> getDirections() {
      var directions = new ArrayList<Direction>();
      directions.add(Direction.getDirection(getPosition(),  1,  1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(getPosition(),  1, -1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(getPosition(),  1,  0, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(getPosition(), -1,  1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(getPosition(), -1, -1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(getPosition(), -1,  0, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(getPosition(),  0,  1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(getPosition(),  0, -1, 1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      
      return directions;
   }
}
