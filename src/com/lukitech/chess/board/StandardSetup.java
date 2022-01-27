package com.lukitech.chess.board;

import com.lukitech.chess.pieces.Bishop;
import com.lukitech.chess.pieces.Color;
import com.lukitech.chess.pieces.King;
import com.lukitech.chess.pieces.Knight;
import com.lukitech.chess.pieces.Pawn;
import com.lukitech.chess.pieces.Queen;
import com.lukitech.chess.pieces.Rook;

public class StandardSetup implements Setup{

   @Override
   public Board setupBoard() {
      var board = new Board();

      
      board.addPiece(new Knight(Color.WHITE), new Position('b', 1));
      board.addPiece(new Knight(Color.WHITE), new Position('g', 1));
      board.addPiece(new Knight(Color.BLACK), new Position('b', 8));
      board.addPiece(new Knight(Color.BLACK), new Position('g', 8));

      board.addPiece(new Queen(Color.WHITE), new Position('d', 1));
      board.addPiece(new Queen(Color.BLACK), new Position('d', 8));

      board.addPiece(new King(Color.WHITE), new Position('e', 1));
      board.addPiece(new King(Color.BLACK), new Position('e', 8));

      board.addPiece(new Rook(Color.WHITE), new Position('a', 1));
      board.addPiece(new Rook(Color.WHITE), new Position('h', 1));
      board.addPiece(new Rook(Color.BLACK), new Position('a', 8));
      board.addPiece(new Rook(Color.BLACK), new Position('h', 8));

      board.addPiece(new Bishop(Color.WHITE), new Position('c', 1));
      board.addPiece(new Bishop(Color.WHITE), new Position('f', 1));
      board.addPiece(new Bishop(Color.BLACK), new Position('c', 8));
      board.addPiece(new Bishop(Color.BLACK), new Position('f', 8));

      board.addPiece(new Pawn(Color.WHITE), new Position('a', 2));
      board.addPiece(new Pawn(Color.WHITE), new Position('b', 2));
      board.addPiece(new Pawn(Color.WHITE), new Position('c', 2));
      board.addPiece(new Pawn(Color.WHITE), new Position('d', 2));
      board.addPiece(new Pawn(Color.WHITE), new Position('e', 2));
      board.addPiece(new Pawn(Color.WHITE), new Position('f', 2));
      board.addPiece(new Pawn(Color.WHITE), new Position('g', 2));
      board.addPiece(new Pawn(Color.WHITE), new Position('h', 2));


      board.addPiece(new Pawn(Color.BLACK), new Position('a', 7));      
      board.addPiece(new Pawn(Color.BLACK), new Position('b', 7));
      board.addPiece(new Pawn(Color.BLACK), new Position('c', 7));
      board.addPiece(new Pawn(Color.BLACK), new Position('d', 7));
      board.addPiece(new Pawn(Color.BLACK), new Position('e', 7));
      board.addPiece(new Pawn(Color.BLACK), new Position('f', 7));
      board.addPiece(new Pawn(Color.BLACK), new Position('g', 7));
      board.addPiece(new Pawn(Color.BLACK), new Position('h', 7));

      return board;
   }
   
}
