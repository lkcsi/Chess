package com.lukitech.chess;

import com.lukitech.chess.board.BoardTest;
import com.lukitech.chess.board.TurnTest;
import com.lukitech.chess.pieces.BishopTest;
import com.lukitech.chess.pieces.KingTest;
import com.lukitech.chess.pieces.KnightTest;
import com.lukitech.chess.pieces.PawnTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({PawnTest.class, BoardTest.class, BishopTest.class, KnightTest.class, KingTest.class, TurnTest.class})
public class ChessTests {

}
