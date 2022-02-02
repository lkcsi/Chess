package com.lukitech.chess.interpreter;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Direction;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.pieces.MoveResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Algebratic implements Interpreter{

    private final Board board;
    private Pattern pattern = Pattern.compile("([A-Z])?([a-h])?([1-8])?(x)?([a-h])([1-8])");

    public Algebratic(Board board){
        this.board = board;
    }

    @Override
    public MoveResult processMove(String move) {
        Matcher matcher = pattern.matcher(move);

        if(!matcher.matches())
            return new MoveResult(false,"Wrong pattern");

        String pieceLetter = matcher.group(1);
        String pieceColumn = matcher.group(2);
        String pieceRow = matcher.group(3);
        String captureMove = matcher.group(4);
        String destinationColumn = matcher.group(5);
        String destinationRow = matcher.group(6);

        var pieces = board.getPieces();
        if(pieceLetter == null)
            pieces = pieces.stream().filter(p -> p.getLetter().equals("P")).collect(Collectors.toList());
        else
            pieces = pieces.stream().filter(p -> p.getLetter().equals(pieceLetter)).collect(Collectors.toList());

        if(pieceColumn != null){
            int column = (pieceColumn.charAt(0) - 'a') + 1;
            pieces = pieces.stream().filter(p -> p.getPosition().getColumn() == column).collect(Collectors.toList());
        }

        if(pieceRow != null){
            int row = Integer.parseInt(pieceRow);
            pieces = pieces.stream().filter(p -> p.getPosition().getRow() == row).collect(Collectors.toList());
        }

        if(destinationColumn == null)
            return new MoveResult(false,"Wrong pattern");
        int column = (destinationColumn.charAt(0) - 'a') + 1;

        if(destinationRow == null)
            return new MoveResult(false,"Wrong pattern");
        int row = Integer.parseInt(destinationRow);

        Position destination = new Position(column, row);

        if(captureMove == null)
            pieces = pieces.stream().filter(p -> p.getDirections().stream().anyMatch(d -> d.contains(destination) && !d.onlyMove(Direction.CAPTURE_MOVE))).collect(Collectors.toList());
        else
            pieces = pieces.stream().filter(p -> p.getDirections().stream().anyMatch(d -> d.contains(destination) && d.canMove(Direction.CAPTURE_MOVE))).collect(Collectors.toList());

        if(pieces.size() == 0)
            return new MoveResult(false, "Invalid move");

        if(pieces.size() > 1)
            return new MoveResult(false, "Ambiguous move");

        return pieces.get(0).move(destination);
    }
}
