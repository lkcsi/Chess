package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;
import com.lukitech.chess.board.Position;

public class Queen extends Piece {

   public Queen(Color color, Position position) {
      super("Queen", color, position);
   }

   @Override
   public char getLetter() {
      return 'Q';
   }

   @Override
   public List<Direction> getDirections() {
      var directions = new ArrayList<Direction>();
      directions.addAll(Bishop.getDirections(getPosition()));
      directions.addAll(Rook.getDirections(getPosition()));
      return directions;
   }



}
