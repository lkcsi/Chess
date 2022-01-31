package com.lukitech.chess.pieces;

public class MoveResult {
   boolean result;
   String message;

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
}
