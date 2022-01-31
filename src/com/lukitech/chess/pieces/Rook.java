package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;
import com.lukitech.chess.board.Position;

public class Rook extends Piece {

   public Rook(Color color) {
      super("R", color);
   }

   @Override
   public char getLetter() {
      return 'R';
   }

   @Override
   public List<Direction> getDirections() {
      List<Direction> directions = new ArrayList<Direction>();
      directions.addAll(getDirections(getPosition()));
      return directions;
   }

   public static List<Direction> getDirections(Position position){
      var directions = new ArrayList<Direction>();
      directions.add(Direction.getLongDirection(position, -1,  0));
      directions.add(Direction.getLongDirection(position,  1,  0));
      directions.add(Direction.getLongDirection(position,  0,  1));
      directions.add(Direction.getLongDirection(position,  0, -1));      
      return directions;
   }

}
