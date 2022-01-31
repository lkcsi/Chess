package com.lukitech.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.lukitech.chess.board.Direction;

public class King extends Piece implements CheckMateable, Ruler{

   public King(Color color){
		super("King", color);	
	}

   @Override
   public char getLetter() {
      return 'K';
   }

   @Override
   public boolean inCheckMate() {
      return false;
   }

   @Override
   public boolean inCheck() {
      //
      return false;
   }

   @Override
   public boolean giveCheck() {
      return false;
   }

   @Override
   public List<Direction> getDirections() {
      
      var directions = new ArrayList<>();
      directions.add(Direction.getStepDirection(getPosition(),  1,  1));
      directions.add(Direction.getStepDirection(getPosition(),  1, -1));
      directions.add(Direction.getStepDirection(getPosition(),  1,  0));
      directions.add(Direction.getStepDirection(getPosition(), -1,  1));
      directions.add(Direction.getStepDirection(getPosition(), -1, -1));
      directions.add(Direction.getStepDirection(getPosition(), -1,  0));
      directions.add(Direction.getStepDirection(getPosition(),  0,  1));
      directions.add(Direction.getStepDirection(getPosition(),  0, -1));
      
      return null;
   }
}
