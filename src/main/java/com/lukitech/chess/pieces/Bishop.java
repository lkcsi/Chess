package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;
import com.lukitech.chess.board.Position;

public class Bishop extends Piece{

   public Bishop(Color color, Position position) {
      super("Bishop", color, position);
   }

   @Override
   public String getLetter() {
      return "B";
   }

   @Override
   public List<Direction> getDirections() {
      List<Direction> directions = new ArrayList<>();
      directions.addAll(getDirections(getPosition()));
      return directions;
   }

   public static List<Direction> getDirections(Position position){
      var directions = new ArrayList<Direction>();
      directions.add(Direction.getDirection(position, -1, -1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(position,  1, -1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(position, -1,  1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      directions.add(Direction.getDirection(position,  1,  1, Direction.CAPTURE_MOVE | Direction.SIMPLE_MOVE));
      return directions;
   }
}
