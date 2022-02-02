package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;

public class Queen extends Piece {

   public Queen(Color color, Position position) {
      super("Queen", color, position);
   }

   @Override
   public String getLetter() {
      return "Q";
   }

   @Override
   public List<Move> getMoves() {
      var moves = new ArrayList<Move>();
      moves.addAll(Bishop.getDirections(getPosition()));
      moves.addAll(Rook.getDirections(getPosition()));
      return moves;
   }



}
