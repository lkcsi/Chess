package com.lukitech.chess.board;

import com.lukitech.chess.pieces.CheckMateable;
import com.lukitech.chess.pieces.Piece;

public interface Board {
   void addPiece(Piece piece, Position position);
   void capture(Piece captured);
   void checkMate(CheckMateable piece);
}
