package com.premiumminds.internship.screenlocking;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2022.
 * 
 * Exercicio do estagio Premium Minds 2022
 * Completado por:
 * 	Catarina Lima (lima.ca.catarina@gmail.com)
 * 
 * Valores para teste retirado de:
 * 	https://www.youtube.com/watch?v=D9dXrKUCfO0&ab_channel=CHMTech
 * 		
 */
@RunWith(JUnit4.class)
public class ScreenLockinPatternTest {
	
	private ScreenLockinPattern slp;

	/**
	 * The corresponding implementations to test.
	 *
	 * If you want, you can make others :)
	 *
	 */
	public ScreenLockinPatternTest() {
		slp = new ScreenLockinPattern();
	};


	@Test
	public void ScreenLockinPatternTestLength0Test()  throws InterruptedException, ExecutionException, TimeoutException {
		Future<Integer> count  = slp.countPatternsFrom(3, 0);
		Integer result = count.get(10, TimeUnit.SECONDS);
		assertEquals(result.intValue(), 0);
	}
	
	
	@Test
	public void ScreenLockinPatternTestLength_1Test()  throws InterruptedException, ExecutionException, TimeoutException {
		Future<Integer> count  = slp.countPatternsFrom(1, -1);
		Integer result = count.get(10, TimeUnit.SECONDS);
		assertEquals(result.intValue(), 0);
	}
	
	
	@Test
	public void ScreenLockinPatternTestFirst0Test()  throws InterruptedException, ExecutionException, TimeoutException {
		Future<Integer> count  = slp.countPatternsFrom(0, 4);
		Integer result = count.get(10, TimeUnit.SECONDS);
		assertEquals(result.intValue(), 0);
	}
	
	
	@Test
	public void ScreenLockinPatternTestFirst_10Test()  throws InterruptedException, ExecutionException, TimeoutException {
		Future<Integer> count  = slp.countPatternsFrom(-10, 4);
		Integer result = count.get(10, TimeUnit.SECONDS);
		assertEquals(result.intValue(), 0);
	}
	
	
	
	@Test
	public void ScreenLockinPatternTestFirst3Length2Test()  throws InterruptedException, ExecutionException, TimeoutException {
		Future<Integer> count  = slp.countPatternsFrom(3, 2);
		Integer result = count.get(10, TimeUnit.SECONDS);
		assertEquals(result.intValue(), 5);
	}


	@Test
	public void ScreenLockinPatternTestLength4Test()  throws InterruptedException, ExecutionException, TimeoutException {

		Integer result = 0;

		for (int i = 1; i <= 9; i++) {
			Future<Integer> count  = slp.countPatternsFrom(i, 4);
			result+= count.get(10, TimeUnit.SECONDS);
		}

		assertEquals(result.intValue(), 1624);
	}
	
	
	@Test
	public void ScreenLockinPatternTestLength5Test()  throws InterruptedException, ExecutionException, TimeoutException {

		Integer result = 0;

		for (int i = 1; i <= 9; i++) {
			Future<Integer> count  = slp.countPatternsFrom(i, 5);
			result+= count.get(10, TimeUnit.SECONDS);
		}

		assertEquals(result.intValue(), 7152);
	}
	
	
	@Test
	public void ScreenLockinPatternTestLength6Test()  throws InterruptedException, ExecutionException, TimeoutException {

		Integer result = 0;

		for (int i = 1; i <= 9; i++) {
			Future<Integer> count  = slp.countPatternsFrom(i, 6);
			result+= count.get(10, TimeUnit.SECONDS);
		}

		assertEquals(result.intValue(), 26016);
	}
	
	
	@Test
	public void ScreenLockinPatternTestLength7Test()  throws InterruptedException, ExecutionException, TimeoutException {

		Integer result = 0;

		for (int i = 1; i <= 9; i++) {
			Future<Integer> count  = slp.countPatternsFrom(i, 7);
			result+= count.get(10, TimeUnit.SECONDS);
		}

		assertEquals(result.intValue(), 72912);
	}
	
	
	@Test
	public void ScreenLockinPatternTestLength8Test()  throws InterruptedException, ExecutionException, TimeoutException {

		Integer result = 0;

		for (int i = 1; i <= 9; i++) {
			Future<Integer> count  = slp.countPatternsFrom(i, 8);
			result+= count.get(10, TimeUnit.SECONDS);
		}

		assertEquals(result.intValue(), 140704);
	}
	
	
	@Test
	public void ScreenLockinPatternTestLength9Test()  throws InterruptedException, ExecutionException, TimeoutException {

		Integer result = 0;

		for (int i = 1; i <= 9; i++) {
			Future<Integer> count  = slp.countPatternsFrom(i, 9);
			result+= count.get(10, TimeUnit.SECONDS);
		}

		assertEquals(result.intValue(), 140704);
	}
}