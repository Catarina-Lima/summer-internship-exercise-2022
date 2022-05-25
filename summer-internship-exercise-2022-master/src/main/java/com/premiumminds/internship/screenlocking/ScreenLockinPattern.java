package com.premiumminds.internship.screenlocking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utils.Coordinate;



/**
 * Created by aamado on 05-05-2022.
 * 
 * 
 * Exercicio do estagio Premium Minds 2022
 * Completado por:
 * 	Catarina Lima (lima.ca.catarina@gmail.com)
 *
 */
class ScreenLockinPattern implements IScreenLockinPattern {


	private HashMap<Integer, Coordinate> screen = new HashMap<>();


	/**
	 * Method to count patterns from firstPoint with the length
	 * @param firstPoint initial matrix position
	 * @param length the number of points used in pattern
	 * @return number of patterns
	 */
	public Future<Integer> countPatternsFrom(int firstPoint, final int length) {

		if (screen.isEmpty()) {
			populateScreen();
		}
		
		ExecutorService executor 
	      = Executors.newSingleThreadExecutor();

		if (length > 9 || length < 1 || firstPoint > 9 || firstPoint < 1) {
			
			return executor.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
				        //Thread.sleep(1000);
				        return 0;
				    }
			});
			
		}
		
		final ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
		t.add(new ArrayList<Integer>());
		t.get(0).add(firstPoint);

		
	    
	    return executor.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
			        //Thread.sleep(1000);
			        return count(t, length);
			    }
		});
	    
	};


	/*
	 * Popula o hashMap com o valor e o objeto Coordinate respetivo
	 */
	private void populateScreen() {
		int number = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				screen.put(number, new Coordinate(i, j, number));
				number++;
			}
		}
	}


	/**
	 * Calcula quanto padroes validos com um certo tamanho podem ser criados
	 * @param seq lista que contem padroes
	 * @param length tamanho do padrao
	 * @return numero de padroes validos
	 */
	@SuppressWarnings("unchecked")
	private int count(ArrayList<ArrayList<Integer>> seq, int length) {

		if (seq.get(0).size() == length) {
			return seq.size();
		}

		ArrayList<ArrayList<Integer>> seqCopy = new ArrayList<>();
		ArrayList<Integer> tryToAddOneMore = new ArrayList<Integer>();

		for (ArrayList<Integer> s : seq) {
			seqCopy.add((ArrayList<Integer>) s.clone());
		}

		for (ArrayList<Integer> s : seqCopy) {

			for (int i = 1; i <= 9; i++) {

				if (!s.contains(i)) {
					tryToAddOneMore = (ArrayList<Integer>) s.clone();
					tryToAddOneMore.add(i);

					if (ValidSequence(tryToAddOneMore, i)) {
						seq.add(tryToAddOneMore);
					}
				}

			}

			seq.remove(s);

		}

		return count(seq, length);

	}


	/**
	 * Valida se uma sequencia tem um padrao valido
	 * @param seq padrao
	 * @param added ultimo elemento adicionado
	 * @return se o padrao eh valido 
	 */
	private boolean ValidSequence(ArrayList<Integer> seq, int added) {

		if (added == 5) {
			return true;
		}

		Coordinate lastCoor = screen.get(added);

		Coordinate lastToOneCoor = screen.get(seq.get(seq.size() - 2));

		if (lastCoor.isDoubleEdge() && lastToOneCoor.isDoubleEdge() ) {
			
			if (lastCoor.equalRows(lastToOneCoor)) { 
				return seq.contains(coordinateToInteger(lastCoor.getRow(), 1)); 
			}
			
			else if (lastCoor.equalColumns(lastToOneCoor)) {
				return seq.contains(coordinateToInteger(1, lastCoor.getColumn())); 
			}
			
			else 
				return seq.contains(5);	
		
		}
		
		if (lastCoor.isEdge() && lastToOneCoor.isEdge() ) {
			
			if (lastCoor.equalRows(lastToOneCoor) || lastCoor.equalColumns(lastToOneCoor)) { 
				return seq.contains(5);
			}
		}

		return true;
	}

	
	
	/**
	 * Devolve o numero da matriz identificado pela posicao (row, column)
	 * @param row linha
	 * @param column coluna
	 * @return valor correspondente ah linha e coluna
	 */
	private Integer coordinateToInteger(Integer row, Integer column) {

		return (row * 3) + column + 1;
	}

}
