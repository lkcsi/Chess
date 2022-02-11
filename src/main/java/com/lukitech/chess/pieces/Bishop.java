package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.moves.*;
import com.lukitech.chess.board.Position;

public class Bishop extends Piece{

   public Bishop(Color color, Position position) {
      super("Bishop", color, position);
   }

   @Override
   public List<Move> getMoves(Board board) {
      MoveFactory positionFactory = new MoveFactory(this, board);

      List<Move> moves = new ArrayList<>();
      moves.addAll(positionFactory.getMoves(-1,-1,10));
      moves.addAll(positionFactory.getMoves(1,-1,10));
      moves.addAll(positionFactory.getMoves(-1,1,10));
      moves.addAll(positionFactory.getMoves(1,1,10));
      return moves;
   }

   @Override
   public String getLetter() {
      return "B";
   }
}
