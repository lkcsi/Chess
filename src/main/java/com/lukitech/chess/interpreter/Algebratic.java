package com.lukitech.chess.interpreter;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveType;
import com.lukitech.chess.pieces.Piece;

import java.util.EnumSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Algebratic implements Interpreter{

    private final Board board;
    private Piece piece;
    private Position position;
    private Pattern pattern = Pattern.compile("([A-Z])?([a-h])?([1-8])?(x)?([a-h])([1-8])");

    public Algebratic(Board board){
        this.board = board;
    }

    @Override
    public boolean processMove(String move) {
        piece = null;
        position = null;

        Matcher matcher = pattern.matcher(move);

        if(!matcher.matches())
            return false;

        String pieceLetter = matcher.group(1);
        String pieceColumn = matcher.group(2);
        String pieceRow = matcher.group(3);
        String captureMark = matcher.group(4);
        String destinationColumn = matcher.group(5);
        String destinationRow = matcher.group(6);

        var pieces = board.getPieces().stream().filter(p -> p.getColor() == board.getColorToMove()).collect(Collectors.toList());

        var letter = pieceLetter == null ? "P" : pieceLetter;
        pieces = pieces.stream().filter(p -> p.getLetter().equals(letter)).collect(Collectors.toList());

        if(pieceColumn != null){
            int column = (pieceColumn.charAt(0) - 'a') + 1;
            pieces = pieces.stream().filter(p -> p.getPosition().getColumn() == column).collect(Collectors.toList());
        }

        if(pieceRow != null){
            int row = Integer.parseInt(pieceRow);
            pieces = pieces.stream().filter(p -> p.getPosition().getRow() == row).collect(Collectors.toList());
        }

        if(destinationColumn == null)
            return false;
        int column = (destinationColumn.charAt(0) - 'a') + 1;

        if(destinationRow == null)
            return false;
        int row = Integer.parseInt(destinationRow);

        position = new Position(column, row);

        if(captureMark == null)
            pieces = pieces.stream().filter(p -> p.getMoves().stream().anyMatch(m -> m.getPositions(p.getPosition()).contains(position) && m.getMoveType() != MoveType.CAPTURE_ONLY)).collect(Collectors.toList());
        else
            pieces = pieces.stream().filter(p -> p.getMoves().stream().anyMatch(m -> m.getPositions(p.getPosition()).contains(position) && m.getMoveType() != MoveType.MOVE_ONLY)).collect(Collectors.toList());

        if(pieces.size() != 1)
            return false;

        piece = pieces.get(0);
        return  true;
    }

    @Override
    public Piece getPiece() {
        return null;
    }

    @Override
    public Position getPosition() {
        return null;
    }
}
