package com.lukitech.chess.moves;

import java.util.Objects;

public class MoveResult {

   public static final MoveResult PieceNotCapturable = new MoveResult(false,"Piece cannot be captured");
   public static final MoveResult NotCaptureMove = new MoveResult(false,"Piece cannot capture this direction");
   public static final MoveResult MoveBlocked = new MoveResult(false,"Move blocked");
   public static final MoveResult WrongDirection = new MoveResult(false, "Wrong direction");
   public static final MoveResult AllowCheck = new MoveResult(false, "This move results check to own king");
   public static final MoveResult CaptureMoveOnly = new MoveResult(false,"Capture move only");
   public static final MoveResult Capture = new MoveResult(true, "Capture");
   public static final MoveResult Move = new MoveResult(true, "Move");

   private boolean result;
   private String message;

   private MoveResult(boolean result, String message){
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
