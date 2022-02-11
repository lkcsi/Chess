package com.lukitech.chess.moves;
import com.lukitech.chess.board.Position;

public class Move {
   private Position position;
   private SpecialAction specialAction;

   public Move(Position position){
      this.position = position;
   }

   public void setSpecialAction(SpecialAction specialAction) {
      this.specialAction = specialAction;
   }

   public SpecialAction getSpecialAction() {
      return specialAction;
   }

   public Position getPosition() {
      return position;
   }
}
