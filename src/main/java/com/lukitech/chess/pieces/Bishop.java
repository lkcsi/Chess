package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.moves.Move;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveFactory;
import com.lukitech.chess.moves.MoveType;

public class Bishop extends Piece{

   public Bishop(Color color, Position position) {
      super("Bishop", color, position);
   }

   @Override
   public String getLetter() {
      return "B";
   }

   @Override
   public List<Move> getMoves() {
      List<Move> directions = new ArrayList<>();
      directions.addAll(getDirections(getPosition()));
      return directions;
   }

   public static List<Move> getDirections(Position position){
      var moves = new ArrayList<Move>();
      var set = EnumSet.of(MoveType.MOVE, MoveType.CAPTURE);
      moves.add(MoveFactory.getDirection(position, -1, -1, set));
      moves.add(MoveFactory.getDirection(position,  1, -1, set));
      moves.add(MoveFactory.getDirection(position, -1,  1, set));
      moves.add(MoveFactory.getDirection(position,  1,  1, set));
      return moves;
   }
}
