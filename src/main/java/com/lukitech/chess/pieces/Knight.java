package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveFactory;
import com.lukitech.chess.moves.MoveType;
import com.lukitech.chess.moves.MoveVector;

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
   public void addMoves() {
      addMove(new Move(new MoveVector(1,2,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(1,-2,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-1,2,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-1,-2,1), MoveType.NORMAL));

      addMove(new Move(new MoveVector(2,1,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(2,-1,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-2,1,1), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-2,-1,1), MoveType.NORMAL));
   }
}