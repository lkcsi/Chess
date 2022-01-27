package com.lukitech.chess;
import com.lukitech.chess.printer.ConsolePrinter;
import com.lukitech.chess.board.*;

public class Chess
{
	public static void main(String args[])
	{

      var setup = new StandardSetup();
      var board = setup.setupBoard();

		var printer = new ConsolePrinter();
      printer.print(board);
	}	
}

