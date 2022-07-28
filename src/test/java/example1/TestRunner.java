package example1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(MathProviderTest1.class,MathProviderTest2.class);
		System.out.println("Total Number of tests " + result.getRunCount());
		System.out.println("Total number of test Failed " + result.getFailureCount());

		// get failure return type ---->List<Failure>
		for (Failure fail : result.getFailures()) {
			System.out.println(fail.getMessage());
		}
		System.out.println(result.wasSuccessful());
	}

}
