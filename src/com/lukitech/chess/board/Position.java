package com.lukitech.chess.board;

public class Position
{
	String columnPattern = "[a-z]{1}";
	char column;
	int row;
	
	public Position(char column, int row)
	{
		if(column < 97 || column > 104)
		{
			throw new RuntimeException(column + " is not a valid column");
		}
		if(row < 1 || row > 8)
		{
			throw new RuntimeException(row + " is not a valid row");
		}
		
		this.column = column;
		this.row = row;
	}

   public boolean equals(Position position){
      return (position.row == this.row && position.column == this.column);
   }
	
	public String toString()
	{
		return "" + column + row;
	}

   public char getColumn() {
      return column;
   }

   public int getRow() {
      return row;
   }
}