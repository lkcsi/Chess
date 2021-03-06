package com.lukitech.chess;
import com.lukitech.chess.interpreter.Algebratic;
import com.lukitech.chess.moves.MoveResult;
import com.lukitech.chess.printer.ConsolePrinter;
import com.lukitech.chess.board.*;
import com.lukitech.chess.pieces.Color;

import java.util.Scanner;

public class Chess
{
	public static void main(String args[])
	{
		var pieceSet = new StandardPieceSet();
		var board = new Board(new StandardPieceSet());

		var printer = new ConsolePrinter();
		var interpeter = new Algebratic(board);

		printer.print(board);
		Scanner scanner = new Scanner(System.in);
		while(true){
			String pattern = scanner.nextLine();
			if(pattern.equalsIgnoreCase("exit"))
				break;

			var moveResult = interpeter.move(pattern);
			System.out.println(moveResult.getMessage());
			printer.print(board);
		}
	}
}

