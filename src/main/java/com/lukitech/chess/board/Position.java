package com.lukitech.chess.board;

public class Position
{
	int column;
	int row;
	
	public Position(int column, int row)
	{
		if(column < 1 || column > 8)
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

	@Override
   public boolean equals(Object position){
		if(position == null)
			return false;
		return (((Position)position).row == this.row && ((Position)position).column == this.column);
   }
	
	public String toString()
	{
		return "" + (char)(column+64) + row;
	}

   public int getColumn() {
      return column;
   }

   public int getRow() {
      return row;
   }
}