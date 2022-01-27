package com.lukitech.chess.board;
import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.pieces.*;

public class Board
{
	private List<Piece> pieces;
	public Board()
	{
		pieces = new ArrayList<>();
	}
	
	public void addPiece(Piece piece, Position position)
	{
		if(pieces.stream().anyMatch(p -> p.getPosition().equals(position)))
         throw new RuntimeException("Position: " + position.toString() + " is already occupied by other piece");

      piece.setPosition(position);
      pieces.add(piece);
	}

   public List<Piece> getPieces(){
      return new ArrayList<>(pieces);
   }

   public String toString(){
      return "";
   }
}