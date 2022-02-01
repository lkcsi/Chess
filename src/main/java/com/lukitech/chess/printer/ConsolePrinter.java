package com.lukitech.chess.printer;

import java.util.Optional;

import com.lukitech.chess.board.*;
import com.lukitech.chess.pieces.*;

public class ConsolePrinter implements Printer{

   @Override
   public void print(StandardBoard board) {
      
      
      for(int row = 8; row >= 1; row--){
         for(int column = 1; column < 9; column++){        
            var position = new Position(column, row);
            String field = "   ";

            Optional<Piece> piece = board.getPieces().stream()
               .filter(p -> p.getPosition().equals(position))
               .findFirst();
    
            if(piece.isPresent()){
               field = " " + piece.get().getLetter() + " ";
               if(piece.get().getColor() == Color.BLACK){
                  field = field.toLowerCase();
               }
            }
            System.out.print(field);
         }
         System.out.println();
      }
   }
}
