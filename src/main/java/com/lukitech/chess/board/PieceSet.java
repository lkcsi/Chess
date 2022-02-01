package com.lukitech.chess.board;

import com.lukitech.chess.pieces.Color;
import com.lukitech.chess.pieces.Piece;

import java.util.List;

public interface PieceSet {
   List<Piece> getPieces(Color color);
}
