package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveFactory;
import com.lukitech.chess.moves.MoveType;

public class Knight extends Piece
{
	public Knight(Color color, Position position){
		super("Knight", color, position);
	}

   @Override
   public String getLetter() {
      return "N";
   }

   @Override
   public List<Move> getMoves() {
      var moves = new ArrayList<Move>();
      var set = EnumSet.of(MoveType.MOVE, MoveType.CAPTURE);
      moves.add(MoveFactory.getDirection( getPosition(),  1, 2, 1, set));
      moves.add(MoveFactory.getDirection( getPosition(),  1, -2, 1, set));
      moves.add(MoveFactory.getDirection( getPosition(),  -1, 2, 1, set));
      moves.add(MoveFactory.getDirection( getPosition(),  -1, -2, 1, set));

      moves.add(MoveFactory.getDirection( getPosition(),  2, 1, 1, set));
      moves.add(MoveFactory.getDirection( getPosition(),  2, -1, 1, set));
      moves.add(MoveFactory.getDirection( getPosition(),  -2, 1, 1, set));
      moves.add(MoveFactory.getDirection( getPosition(),  -2, -1, 1, set));

      return moves;
   }
}