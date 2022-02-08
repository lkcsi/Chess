package com.lukitech.chess.pieces;
import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.*;
import com.lukitech.chess.moves.Move;

public abstract class Piece
{
	private String name;
	private Color color;
	private Position position;
	private List<Move> moves;

	public Piece(String name, Color color, Position position){
		this.name = name;
		this.color = color;
        this.position = position;
		moves = new ArrayList<>();
		addMoves();
	}

	public void addMove(Move move){
		moves.add(move);
	}

	public List<Move> getMoves(){
		return new ArrayList<>(moves);
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

    public abstract String getLetter();

	public void update(){}
	public void addMoves(){}

    public Color getColor(){
      return color;
   }
}