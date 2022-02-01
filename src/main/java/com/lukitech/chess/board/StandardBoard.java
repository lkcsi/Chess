package com.lukitech.chess.board;

import com.lukitech.chess.pieces.*;

public class StandardBoard extends Board
{
	
	public StandardBoard(PieceSet pieceSet)
	{
        super(pieceSet);
	}

    public StandardBoard(PieceSet white, PieceSet black)
    {
        super(white, black);
    }



   public String toString(){
      return "";
   }

   @Override
   public void checkMate(CheckMateable piece) {
      
   }
}