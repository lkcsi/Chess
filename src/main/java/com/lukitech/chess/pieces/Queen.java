package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveType;
import com.lukitech.chess.moves.MoveVector;

public class Queen extends Piece {

   public Queen(Color color, Position position) {
      super("Queen", color, position);
   }

   @Override
   public String getLetter() {
      return "Q";
   }

   @Override
   public void addMoves() {
      addMove(new Move(new MoveVector(1,1,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(1,-1,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(1,0,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-1,1,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-1,-1,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(-1,0,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(0,1,10), MoveType.NORMAL));
      addMove(new Move(new MoveVector(0,-1,10), MoveType.NORMAL));
   }
}
