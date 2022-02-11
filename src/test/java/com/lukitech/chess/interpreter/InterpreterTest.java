package com.lukitech.chess.interpreter;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.StandardPieceSet;
import com.lukitech.chess.moves.MovePerformer;
import com.lukitech.chess.moves.MoveResult;
import com.lukitech.chess.printer.ConsolePrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InterpreterTest {
    private Board board;
    private String moves =
            "e4,d5," + "f4,Nc6," + "Bb5,a6," + "Bc6,bc6," + "Qf3,e6," + "Kd1,Nf6," + "e5,Ne4," +
            "d3,f5," + "Ne2,Qh4," + "Be3,c5," + "Qf1,d4," + "Bg1,Rb8," + "g3,Qh5," + "g4,Qg4," +
            "h3,Ng3," + "hg4,Nf1," + "Bf2,Ne3," + "Be3,de3," + "Nbc3,Rb2," + "Na4,Bb7," + "Nb2,Bh1," + "gf5,ef5," +
            "Nc4,g5," + "Ne3,gf4," + "Nf5,Rg8," + "Kd2,Bd5," + "Nf4,Rg5," + "Nd5,Rf5," + "Nf6,Kf7," + "Re1,h5," +
            "Kc1,Bh6," + "Kb2,Bg7," + "Nd5,Be5," + "Re5,Re5," + "Nc7,h4," + "Na6,h3," + "Nc5,Rc5," + "d4,Rh5," +
            "a4,h2," + "d5,Rd5," + "c4,Rh5," + "a5,Ra5";
    private Algebratic interpreter;

    @BeforeEach
    void setup(){
        board = new Board(new StandardPieceSet());
        interpreter = new Algebratic(board);
    }

    @Test
    void playMatch(){
        for(String move : moves.split(",")){
            var moveResult = interpreter.move(move);
            Assertions.assertEquals(MoveResult.Move, moveResult, moveResult.getMessage());
        }
        new ConsolePrinter().print(board);
    }
}
