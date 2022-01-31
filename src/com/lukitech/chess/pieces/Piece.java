package com.lukitech.chess.pieces;
import java.util.List;
import java.util.stream.Collectors;

import com.lukitech.chess.board.*;

public abstract class Piece
{
	private String name;
	private Color color;
	private Position position;
   private Board board;

	
	public Piece(String name, Color color){
		this.name = name;
		this.color = color;
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

   public abstract char getLetter();

   public boolean giveCheck(){
      for(var direction : getDirections().stream().filter(d -> d.captureDirection()).collect(Collectors.toList())){
         for(var pos : direction.getPositions()){
            var piece = getBoard().getPieceByPosition(pos);
            if(piece == null)
               continue;
            if(piece.getColor() == color)
               break;
            if(!(piece instanceof CheckMateable))
               break;
            return true;
         }
      }
      return false;
   }
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
            if(pos != newPosition)
               return new MoveResult(false, "Move blocked");
            if(!direction.captureDirection())
               return new MoveResult(false, "Cannot capture this direction");
            if(piece.getColor() == getColor() || piece instanceof CheckMateable)
               return new MoveResult(false, "Cannot capture this piece");   
         }
         if(pos == newPosition){
            position = newPosition;
            board.capture(piece);
            return new MoveResult(true, this.name + " captured " + piece.name + " in position " + newPosition.toString());
         }
      }
      position = newPosition;
      return new MoveResult(true, this.name + " moved to " + newPosition.toString());
   }
	
   public Color getColor(){
      return color;
   }
}