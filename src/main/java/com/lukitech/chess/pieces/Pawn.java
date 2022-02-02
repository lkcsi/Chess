package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveFactory;
import com.lukitech.chess.moves.MoveType;

public class Pawn extends Piece {

   private boolean enPassant;

   public Pawn(Color color, Position position) {
      super("Pawn.json", color, position);
      enPassant = false;
   }

   public boolean enPassantAvailable(){
      return enPassant;
   }

   @Override
   public String getLetter() {
      return "P";
   }

   @Override
   public List<Move> getMoves() {
      var moves = new ArrayList<Move>();
      int row = getPosition().getRow();
      int dir = getColor() == Color.BLACK ? -1 : 1;

      if((Color.BLACK == getColor() && row == 7) || Color.WHITE == getColor() && row == 2){
         moves.add(MoveFactory.getDirection(getPosition(), 0, 1 * dir, 2, EnumSet.of(MoveType.MOVE)));
      }
      moves.add(MoveFactory.getDirection(getPosition(), 0, 1 * dir, 1, EnumSet.of(MoveType.MOVE)));

      moves.add(MoveFactory.getDirection(getPosition(),  1, 1 * dir, 1, EnumSet.of(MoveType.CAPTURE)));
      moves.add(MoveFactory.getDirection(getPosition(), -1, 1 * dir, 1, EnumSet.of(MoveType.CAPTURE)));
      
      return moves;
   }
}
