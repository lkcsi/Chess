package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveFactory;
import com.lukitech.chess.moves.MoveType;

public class King extends Piece implements CheckMateable, Ruler{

   public King(Color color, Position position){
		super("King", color, position);
	}

   @Override
   public String getLetter() {
      return "K";
   }

   @Override
   public boolean inCheckMate() {
      return false;
   }

   @Override
   public boolean inCheck() {
      //
      return false;
   }

   @Override
   public List<Move> getMoves() {
      var moves = new ArrayList<Move>();
      var set = EnumSet.of(MoveType.MOVE, MoveType.CAPTURE);
      moves.add(MoveFactory.getDirection(getPosition(),  1,  1, 1, set));
      moves.add(MoveFactory.getDirection(getPosition(),  1, -1, 1, set));
      moves.add(MoveFactory.getDirection(getPosition(),  1,  0, 1, set));
      moves.add(MoveFactory.getDirection(getPosition(), -1,  1, 1, set));
      moves.add(MoveFactory.getDirection(getPosition(), -1, -1, 1, set));
      moves.add(MoveFactory.getDirection(getPosition(), -1,  0, 1, set));
      moves.add(MoveFactory.getDirection(getPosition(),  0,  1, 1, set));
      moves.add(MoveFactory.getDirection(getPosition(),  0, -1, 1, set));
      
      return moves;
   }
}
