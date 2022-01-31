package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;
import com.lukitech.chess.board.Position;

public class Bishop extends Piece{

   public Bishop(Color color) {
      super("Bishop", color);
   }

   @Override
   public char getLetter() {
      return 'B';
   }

   @Override
   public List<Direction> getDirections() {
      List<Direction> directions = new ArrayList<Direction>();
      directions.addAll(getDirections(getPosition()));
      return directions;
   }

   public static List<Direction> getDirections(Position position){
      var directions = new ArrayList<Direction>();
      directions.add(Direction.getLongDirection(position, -1, -1));
      directions.add(Direction.getLongDirection(position,  1, -1));
      directions.add(Direction.getLongDirection(position, -1,  1));
      directions.add(Direction.getLongDirection(position,  1,  1));      
      return directions;
   }
}
