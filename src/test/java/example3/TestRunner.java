package example3;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		
		Result result=JUnitCore.runClasses(LoginPageTest.class);	
		System.out.println("number of test count " + result.getRunCount());
		System.out.println("number of failure test count " + result.getFailureCount());
	
		for(Failure fail: result.getFailures()) {
			System.out.println(fail.getMessage());
		}
		
		System.out.println(result.wasSuccessful());
	}
}
