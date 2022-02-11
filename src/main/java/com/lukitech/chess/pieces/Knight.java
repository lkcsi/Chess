package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.moves.*;
import com.lukitech.chess.board.Position;

public class Knight extends Piece
{
	public Knight(Color color, Position position){
		super("Knight", color, position);
	}

   @Override
   public List<Move> getMoves(Board board) {
      List<Move> moves = new ArrayList<>();
      MoveFactory positionFactory = new MoveFactory(this, board);
      moves.addAll(positionFactory.getMoves(1,2,1));
      moves.addAll(positionFactory.getMoves(1,-2,1));
      moves.addAll(positionFactory.getMoves(-1,2,1));
      moves.addAll(positionFactory.getMoves(-1,-2,1));

      moves.addAll(positionFactory.getMoves(2,1,1));
      moves.addAll(positionFactory.getMoves(2,-1,1));
      moves.addAll(positionFactory.getMoves(-2,1,1));
      moves.addAll(positionFactory.getMoves(-2,-1,1));

      return moves;
   }

   @Override
   public String getLetter() {
      return "N";
   }
}