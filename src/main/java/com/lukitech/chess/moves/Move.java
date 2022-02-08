package com.lukitech.chess.moves;


import com.lukitech.chess.board.Position;
import com.lukitech.chess.pieces.Piece;

import java.util.ArrayList;

public class Move {
   private MoveVector moveVector;
   private SpecialAction specialAction;
   private SpecialCondition specialCondition;
   private MoveType moveType;

   public Move(MoveVector moveVector, MoveType moveType){
      this.moveType = moveType;
      this.moveVector = moveVector;
   }

   public ArrayList<Position> getPositions(Position position){
      var result = new ArrayList<Position>();
      int col = position.getColumn() + moveVector.getColStep();
      int row = position.getRow() + moveVector.getRowStep();

      while(col < 9 && row < 9 && col > 0 && row > 0 && result.size() < moveVector.getStepCount()){
         result.add(new Position(col, row));
         col = col + moveVector.getColStep();
         row = row + moveVector.getRowStep();
      }
      return result;
   }

   public void setSpecialAction(SpecialAction specialAction) {
      this.specialAction = specialAction;
   }
   public  void setSpecialCondition(SpecialCondition specialCondition) {
      this.specialCondition = specialCondition;
   }
   public SpecialAction getSpecialAction() {
      return specialAction;
   }
   public SpecialCondition getSpecialCondition() {
      return specialCondition;
   }

   public MoveVector getMoveVector() {
      return moveVector;
   }

   public MoveType getMoveType() {
      return moveType;
   }
}
