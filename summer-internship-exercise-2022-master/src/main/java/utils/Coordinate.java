package utils;

/**
 * Exercicio do estagio Premium Minds 2022
 * Completado por:
 * 	Catarina Lima (lima.ca.catarina@gmail.com)
 *
 * Esta classe representa uma posicao numa matriz quadrada 3 * 3 com valores de 1 a 9
 * Se a posicao representar um canto da matriz eh considerada DoubleEdge
 * Se a posicao estiver apenas num lado da matriz eh considerada Edge
 * 
 */

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
