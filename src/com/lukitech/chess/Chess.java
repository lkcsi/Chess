package com.lukitech.chess;
import com.lukitech.chess.printer.ConsolePrinter;
import com.lukitech.chess.board.*;
import com.lukitech.chess.pieces.Color;

public class Chess
{
	public static void main(String args[])
	{

      var pieceSet = new StandardPieceSet();
      var board = new StandardBoard();
      pieceSet.setupBoard(board, Color.WHITE);
      pieceSet.setupBoard(board, Color.BLACK);

		var printer = new ConsolePrinter();
      printer.print(board);
	}	
}

