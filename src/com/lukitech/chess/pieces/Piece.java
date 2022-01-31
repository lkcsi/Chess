package com.lukitech.chess.pieces;
import com.lukitech.chess.board.*;

public abstract class Piece
{
	private String name;
	private Color color;
	private Position position;
   private StandardBoard board;

	
	public Piece(String name, Color color){
		this.name = name;
		this.color = color;
	}
	
	public void setPosition(Position position){
		this.position = new Position(position.getColumn(), position.getRow());
	}
	
   public void setBoard(StandardBoard board){
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
   public abstract boolean giveCheck();
   
   public MoveResult move(Position newPosition){
      position = newPosition;
      return new MoveResult(true, this.name + " moved to " + newPosition.toString());
   }

   public MoveResult capture(Position newPostion, Piece piece){
      position = newPostion;
      piece.captured();
      return new MoveResult(true, this.name + " captured " + piece.name + " in position " + newPostion.toString());
   }

   public void captured(){
      board.capture(this);
   }
	
   public Color getColor(){
      return color;
   }
}