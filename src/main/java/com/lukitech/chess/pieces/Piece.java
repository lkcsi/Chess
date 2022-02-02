package com.lukitech.chess.pieces;
import java.util.List;

import com.lukitech.chess.board.*;

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

   public abstract List<Direction> getDirections();
   
   public MoveResult move(Position newPosition){
      if(newPosition.equals(this.getPosition()))
         return new MoveResult(false, "Not a move");

      var direction = getDirections().stream().filter(d -> d.contains(newPosition)).findFirst().orElse(null);
      if(direction == null)
         return new MoveResult(false, "Not a valid move");

      for(var pos : direction.getPositions()){
         var piece = board.getPieceByPosition(pos);
         if(piece != null)
         {
            if(!pos.equals(newPosition))
               return new MoveResult(false, "Move blocked");
            if(!direction.canMove(Direction.CAPTURE_MOVE))
               return new MoveResult(false, "Cannot capture this direction");
            if(piece.getColor() == getColor() || piece instanceof CheckMateable)
               return new MoveResult(false, "Cannot capture this piece");

            return captured(pos, piece);
         }
         if(pos.equals(newPosition)){
             return moved(newPosition);
         }
      }
      return new MoveResult(false, "Unreachable in theory");
   }

   private MoveResult checkSafeMove(Position position){
       var originalPosition = getPosition();
       setPosition(position);
       if(board.inCheck(color)) {
           setPosition(originalPosition);
           return new MoveResult(false, "This move results a check of your own king");
       }
       return new MoveResult(true, "");
   }

    private MoveResult captured(Position position, Piece piece){
       var checkSafe = checkSafeMove(position);
       if(checkSafe.result != true)
           return checkSafe;

       board.capture(piece);
       return new MoveResult(true, this.name + " captured " + piece.name + " in position " + position.toString());
   }

    private MoveResult moved(Position position){
        var checkSafe = checkSafeMove(position);
        if(checkSafe.result != true)
            return checkSafe;

       return new MoveResult(true, this.name + " moved to " + position.toString());
   }

   public Color getColor(){
      return color;
   }
}