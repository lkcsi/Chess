package com.lukitech.chess.pieces;
import com.lukitech.chess.board.*;

public abstract class Piece
{
	private String name;
	private Color color;
	private Position position;

	
	public Piece(String name, Color color){
		this.name = name;
		this.color = color;
	}
	
	public void setPosition(Position position){
		this.position = new Position(position.getColumn(), position.getRow());
	}
	
	public Position getPosition(){
		return position;
	}
	
	public String toString(){
		return color + " " + name + " " + position.toString();
	}

   public abstract char getLetter();

   public abstract boolean isLegalMove(Position position);
	
   public Color getColor(){
      return color;
   }

	public void move(int x, int y){
		System.out.println(color + " " + name + " moves to: " + x + ", " + y);
	}
}