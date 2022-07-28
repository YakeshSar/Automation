package example1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathProviderTest2 {

	MathProvider mp;

	public MathProviderTest2() {
		mp = new MathProvider();
	}

	@Test
	public void multiply() {
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		int first = 10;
		int second = 20;
		assertEquals(first * second, mp.multiply(first, second));
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

}
