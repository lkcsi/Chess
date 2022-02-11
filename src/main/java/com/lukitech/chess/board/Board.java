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

   public Board(){

   }

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
      if(colorToMove == Color.WHITE){
         pieces.stream().filter(p -> p.getColor() == Color.BLACK).forEach(p -> p.update());
         colorToMove =  Color.BLACK;
      }
      else{
         pieces.stream().filter(p -> p.getColor() == Color.WHITE).forEach(p -> p.update());
         colorToMove = Color.WHITE;
      }
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
         if(piece.getMoves(this).stream().anyMatch(m -> m.getPosition().equals(king.getPosition()))){
            return true;
         }
      }
      return false;
   }

   public Board copy(){
      Board board = new Board();
      pieces.forEach(p -> board.pieces.add(p));
      return board;
   }
}
