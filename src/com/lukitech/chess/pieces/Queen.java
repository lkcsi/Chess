package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;

public class Queen extends Piece {

   public Queen(Color color) {
      super("Queen", color);      
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
