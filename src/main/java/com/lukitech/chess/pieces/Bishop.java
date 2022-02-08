package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveFactory;
import com.lukitech.chess.moves.MoveType;
import com.lukitech.chess.moves.MoveVector;

public class Bishop extends Piece{

   public Bishop(Color color, Position position) {
      super("Bishop", color, position);
   }

   @Override
   public String getLetter() {
      return "B";
   }

   @Override
   public void addMoves(){
      addMove(new Move(new MoveVector(-1,-1,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(1,-1,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-1,1,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(1,1,10), MoveType.NORMAL));
   }
}
