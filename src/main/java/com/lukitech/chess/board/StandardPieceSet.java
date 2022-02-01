package com.lukitech.chess.board;
import com.lukitech.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class StandardPieceSet implements PieceSet{

   @Override
   public List<Piece> getPieces(Color color)
   {
      var pieces = new ArrayList<Piece>();

      int rank1 = color == Color.BLACK? 8 : 1;
      int rank2 = color == Color.BLACK? 7 : 2;

      pieces.add(new Queen(color, new Position(4, rank1)));
      pieces.add(new Knight(color, new Position(2, rank1)));
      pieces.add(new Knight(color, new Position(7, rank1)));
      pieces.add(new King(color, new Position(5, rank1)));
      pieces.add(new Rook(color, new Position(1, rank1)));
      pieces.add(new Rook(color, new Position(8, rank1)));
      pieces.add(new Bishop(color, new Position(3, rank1)));
      pieces.add(new Bishop(color, new Position(6, rank1)));
      pieces.add(new Pawn(color, new Position(1, rank2)));
      pieces.add(new Pawn(color, new Position(2, rank2)));
      pieces.add(new Pawn(color, new Position(3, rank2)));
      pieces.add(new Pawn(color, new Position(4, rank2)));
      pieces.add(new Pawn(color, new Position(5, rank2)));
      pieces.add(new Pawn(color, new Position(6, rank2)));
      pieces.add(new Pawn(color, new Position(7, rank2)));
      pieces.add(new Pawn(color, new Position(8, rank2)));

      return pieces;
   }

}
