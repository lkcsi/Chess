package com.lukitech.chess.board;
import com.lukitech.chess.pieces.*;

public class StandardPieceSet implements PieceSet{

   @Override
   public void setupBoard(Board board, Color color) {
      getPieces(board, color);
   }
   
   void getPieces(Board board, Color color)
   {
      int rank1 = color == Color.BLACK? 8 : 1;
      int rank2 = color == Color.BLACK? 7 : 2;

      board.addPiece(new Queen(color), new Position(4, rank1));
      board.addPiece(new Knight(color), new Position(2, rank1));
      board.addPiece(new Knight(color), new Position(7, rank1));
      board.addPiece(new King(color), new Position(5, rank1));
      board.addPiece(new Rook(color), new Position(1, rank1));
      board.addPiece(new Rook(color), new Position(8, rank1));
      board.addPiece(new Bishop(color), new Position(3, rank1));
      board.addPiece(new Bishop(color), new Position(6, rank1));
      board.addPiece(new Pawn(color), new Position(1, rank2));      
      board.addPiece(new Pawn(color), new Position(2, rank2));
      board.addPiece(new Pawn(color), new Position(3, rank2));
      board.addPiece(new Pawn(color), new Position(4, rank2));
      board.addPiece(new Pawn(color), new Position(5, rank2));
      board.addPiece(new Pawn(color), new Position(6, rank2));
      board.addPiece(new Pawn(color), new Position(7, rank2));
      board.addPiece(new Pawn(color), new Position(8, rank2));
   }

}
