package com.lukitech.chess.board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.lukitech.chess.pieces.CheckMateable;
import com.lukitech.chess.pieces.Color;
import com.lukitech.chess.pieces.Piece;

public class Board {

   private List<Piece> pieces = new ArrayList<>();
   private Color colorToMove = Color.WHITE;

   public Board(PieceSet pieceSet){
        pieceSet.getPieces(Color.WHITE).forEach(p -> addPiece(p));
        pieceSet.getPieces(Color.BLACK).forEach(p -> addPiece(p));
   }

   public Board(PieceSet white, PieceSet black){
      white.getPieces(Color.WHITE).forEach(p -> addPiece(p));
      black.getPieces(Color.BLACK).forEach(p -> addPiece(p));
   }

	public Piece addPiece(Piece piece){
		if(pieces.stream().anyMatch(p -> p.getPosition().equals(piece.getPosition())))
         throw new RuntimeException("Position: " + piece.getPosition().toString() + " is already occupied by other piece");

      pieces.add(piece);
      return  piece;
	}


   public List<Piece> getPieces(){
      return new ArrayList<>(pieces);
   }

   public void capture(Piece captured){
      pieces.remove(captured);
   }

   public void checkMate(CheckMateable piece){

   }
   
   public Piece getPieceByPosition(Position position){
      return getPieces().stream().filter(p -> p.getPosition().equals(position)).findAny().orElse(null);
   }

   public Piece removePieceFromPosition(Position position) {
      var piece = getPieceByPosition(position);
      removePiece(piece);
      return piece;
   }

   public void endTurn(){
      colorToMove = colorToMove == Color.WHITE ? Color.BLACK : Color.WHITE;
   }

   public Color getColorToMove(){
      return colorToMove;
   }

   public boolean removePiece(Piece piece){
      return pieces.remove(piece);
   }

   public boolean inCheck(Color color){
      var king = getPieces().stream()
              .filter(p -> p instanceof CheckMateable && p.getColor() == color)
              .findAny().orElseGet(null);

      if(king == null)
         return false;

      var opponents = getPieces().stream().filter(p -> p.getColor() != color).collect(Collectors.toList());
      for (var piece : opponents){
         if(givesCheck(piece, king)){
            return true;
         }
      }
      return false;
   }

   private boolean givesCheck(Piece piece, Piece king){
      for(var move : piece.getMoves()){
         var positions = move.getPositions(piece.getPosition());
         if(!positions.contains(king.getPosition()))
            continue;

         for(var pos : positions){
            var otherPiece = getPieceByPosition(pos);
            if(otherPiece == null)
               continue;
            if(otherPiece.equals(king))
               return true;
            break;
         }
      }
      return false;
   }
}
