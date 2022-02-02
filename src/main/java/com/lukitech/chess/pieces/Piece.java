package com.lukitech.chess.pieces;
import java.util.EnumSet;
import java.util.List;

import com.lukitech.chess.board.*;
import com.lukitech.chess.moves.Move;
import com.lukitech.chess.moves.MoveResult;
import com.lukitech.chess.moves.MoveType;

public abstract class Piece
{
	private String name;
	private Color color;
	private Position position;
    private Board board;

	
	public Piece(String name, Color color, Position position){
		this.name = name;
		this.color = color;
        this.position = position;
	}
	
	public void setPosition(Position position){
		this.position = new Position(position.getColumn(), position.getRow());
	}
	
    public void setBoard(Board board){
      this.board = board;
   }

    public Board getBoard(){
      return board;
   }

	public Position getPosition(){
		return position;
	}
	
	public String toString(){
		return color + " " + name + " " + position.toString();
	}

    public abstract String getLetter();

   public abstract List<Move> getMoves();
   
   public MoveResult move(Position newPosition){
      if(newPosition.equals(this.getPosition()))
          return MoveResult.WrongDirection;

      var move = getMoves().stream().filter(d -> d.contains(newPosition)).findFirst().orElse(null);
      if(move == null)
          return MoveResult.WrongDirection;

      for(var pos : move.getPositions()){
         var piece = board.getPieceByPosition(pos);
         if(piece != null)
         {
            if(!pos.equals(newPosition))
               return MoveResult.MoveBlocked;
            if(piece.getColor() == getColor())
                return MoveResult.MoveBlocked;
            if(!move.moveTypes().contains(MoveType.CAPTURE))
                return MoveResult.NotCaptureMove;
            if(piece instanceof CheckMateable)
                return MoveResult.PieceNotCapturable;

            return captured(pos, piece);
         }
         if(pos.equals(newPosition)){
             if(move.moveTypes().equals(EnumSet.of(MoveType.CAPTURE)))
                 return MoveResult.CaptureMoveOnly;
             return moved(newPosition);
         }
      }
      return MoveResult.WrongDirection;
   }

   private MoveResult checkSafeMove(Position position, Piece piece, MoveResult moveResult){
       var originalPosition = getPosition();
       setPosition(position);
       if(board.inCheck(color)) {
           setPosition(originalPosition);
           return MoveResult.AllowCheck;
       }
       if(moveResult.equals(MoveResult.Capture))
           board.capture(piece);
       board.endTurn();
       return moveResult;
   }

    private MoveResult captured(Position position, Piece piece){
       return checkSafeMove(position, piece, MoveResult.Capture);
   }

    private MoveResult moved(Position position){
       return checkSafeMove(position, null, MoveResult.Move);
   }

   public Color getColor(){
      return color;
   }
}