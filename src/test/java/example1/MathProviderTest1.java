package example1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathProviderTest1 {
	
		MathProvider mp;
		
		public MathProviderTest1(){
			mp= new MathProvider();
		}
		
		@Test
		public void add() {
			System.out.println("Starting test " +new Object() {}.getClass().getEnclosingMethod().getName());
			int first=10;
			int second=20;
			assertEquals(first+second, mp.add(first, second));
			System.out.println("Ending test" + new Object() {}.getClass().getEnclosingMethod().getName());
		}

		
		@Test
		public void subtract() {
			System.out.println("Starting test " +new Object() {}.getClass().getEnclosingMethod().getName());
			int first=10;
			int second=20;
			assertEquals(first-second, mp.subtract(first, second));
			System.out.println("Ending test" + new Object() {}.getClass().getEnclosingMethod().getName());
		}
}
