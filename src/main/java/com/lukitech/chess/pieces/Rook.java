package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveFactory;
import com.lukitech.chess.moves.MoveType;
import com.lukitech.chess.moves.MoveVector;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

   public Rook(Color color, Position position) {
      super("Rook", color, position);
   }

   @Override
   public List<Move> getMoves(Board board) {
      var moves = new ArrayList<Move>();
      var moveFactory = new MoveFactory(this, board);
      moves.addAll(moveFactory.getMoves(-1,0,10));
      moves.addAll(moveFactory.getMoves(1,0,10));
      moves.addAll(moveFactory.getMoves(0,1,10));
      moves.addAll(moveFactory.getMoves(0,-1,10));

      return moves;
   }

   @Override
   public String getLetter() {
      return "R";
   }
}
