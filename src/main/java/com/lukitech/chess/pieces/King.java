package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveFactory;
import com.lukitech.chess.moves.MoveType;
import com.lukitech.chess.moves.MoveVector;

public class King extends Piece implements CheckMateable, Ruler{

   public King(Color color, Position position){
		super("King", color, position);
	}

   @Override
   public String getLetter() {
      return "K";
   }

   @Override
   public void addMoves() {
      addMove(new Move(new MoveVector(1,1,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(1,-1,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(1,0,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-1,1,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-1,-1,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-1,0,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(0,1,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(0,-1,1), MoveType.NORMAL));
   }
}
