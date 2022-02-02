package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveFactory;
import com.lukitech.chess.moves.MoveType;

public class Rook extends Piece {

   public Rook(Color color, Position position) {
      super("Rook", color, position);
   }

   @Override
   public String getLetter() {
      return "R";
   }

   @Override
   public List<Move> getMoves() {
      List<Move> moves = new ArrayList<>();
      moves.addAll(getDirections(getPosition()));
      return moves;
   }

   public static List<Move> getDirections(Position position){
      var moves = new ArrayList<Move>();
      var set = EnumSet.of(MoveType.CAPTURE, MoveType.MOVE);
      moves.add(MoveFactory.getDirection(position, -1,  0, set));
      moves.add(MoveFactory.getDirection(position,  1,  0, set));
      moves.add(MoveFactory.getDirection(position,  0,  1, set));
      moves.add(MoveFactory.getDirection(position,  0, -1, set));
      return moves;
   }

}
