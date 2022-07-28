package example2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	
	public static void main(String[] args) {
		
		Result result=JUnitCore.runClasses(LoginAppWirhoutUsingPOM.class);
		System.out.println("Number of test executed " + result.getRunCount());
		System.out.println("Number of failure test " + result.getFailureCount());
		
		for(Failure fail : result.getFailures()) {
			System.out.println(fail.getMessage());
		}
		System.out.println(result.wasSuccessful());
	}

}
