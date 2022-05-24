package utils;

import java.util.Arrays;

public class Coordinate {

	private Integer row;
	private Integer column;
	private Integer value;
	private boolean doubleEdge;
	

	public Coordinate(Integer r, Integer c, Integer v) {

		row = r;
		column = c;
		value = v;
		doubleEdge = (v==1 || v==3 || v==7 || v==9) ? true : false;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getColumn() {
		return column;
	}
	
	public boolean equalRows(Coordinate other) {
		return this.row == other.row;
	}
	
	public boolean equalColumns(Coordinate other) {
		return this.column == other.column;
	}
	
	public boolean isDoubleEdge() {
		return doubleEdge;
	}
	
	public boolean isEdge() {
		return (value == 5) ? false : !doubleEdge;
	}
	

	

}
