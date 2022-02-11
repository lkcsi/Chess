package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.moves.*;
import com.lukitech.chess.board.Position;

public class King extends Piece implements CheckMateable, Ruler{

   public King(Color color, Position position){
		super("King", color, position);
	}

   @Override
   public List<Move> getMoves(Board board) {
      MoveFactory positionFactory = new MoveFactory(this, board);
      List<Move> moves = new ArrayList<>();
      moves.addAll(positionFactory.getMoves(1,1,1));
      moves.addAll(positionFactory.getMoves(1,-1,1));
      moves.addAll(positionFactory.getMoves(1,0,1));
      moves.addAll(positionFactory.getMoves(-1,1,1));
      moves.addAll(positionFactory.getMoves(-1,-1,1));
      moves.addAll(positionFactory.getMoves(-1,0,1));
      moves.addAll(positionFactory.getMoves(0,1,1));
      moves.addAll(positionFactory.getMoves(0,-1,1));

      return moves;
   }
   @Override
   public String getLetter() {
      return "K";
   }

}
