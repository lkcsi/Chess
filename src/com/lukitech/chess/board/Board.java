package com.lukitech.chess.board;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.pieces.CheckMateable;
import com.lukitech.chess.pieces.Piece;

public abstract class Board {



   private List<Piece> pieces;

   public Board(){
		pieces = new ArrayList<>();
   }

	public void addPiece(Piece piece, Position position){
		if(pieces.stream().anyMatch(p -> p.getPosition().equals(position)))
         throw new RuntimeException("Position: " + position.toString() + " is already occupied by other piece");

      piece.setPosition(position);
      piece.setBoard(this);
      pieces.add(piece);
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
}
