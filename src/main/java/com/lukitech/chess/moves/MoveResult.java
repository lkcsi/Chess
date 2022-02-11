package com.lukitech.chess.moves;

import java.util.Objects;

public class MoveResult {

   public static final MoveResult NotValidMove = new MoveResult(false, "No a valid move");
   public static final MoveResult AllowCheck = new MoveResult(false, "This move results check to own king");
   public static final MoveResult Move = new MoveResult(true, "Move");
   public static final MoveResult NotYourTurn = new MoveResult(true, "Not your turn");
   public static final MoveResult Ambigous = new MoveResult(false, "Ambigous move");


   private boolean result;
   private String message;

   public MoveResult(boolean result, String message){
      this.result = result;
      this.message = message;
   }

   public String getMessage(){
      return message;
   }

   public boolean getResult(){
      return result;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      MoveResult that = (MoveResult) o;
      return result == that.result && Objects.equals(message, that.message);
   }

   @Override
   public int hashCode() {
      return Objects.hash(result, message);
   }
}
