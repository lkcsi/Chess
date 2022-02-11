package com.lukitech.chess.pieces;
import java.util.List;

import com.lukitech.chess.board.*;
import com.lukitech.chess.moves.Move;
import com.lukitech.chess.moves.MoveFactory;

public abstract class Piece
{
	protected String name;
	protected Color color;
	protected Position position;

	public Piece(String name, Color color, Position position){
		this.name = name;
		this.color = color;
        this.position = position;
	}

	public abstract List<Move> getMoves(Board board);

	public void setPosition(Position position){
		this.position = new Position(position.getColumn(), position.getRow());
	}
	
	public Position getPosition(){
		return position;
	}
	
	public String toString(){
		return color + " " + name + " " + position.toString();
	}

    public abstract String getLetter();

	public void update(){}

    public Color getColor(){
      return color;
   }
}