package practicet1;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test {
	
	@Parameters({"TestData"})
	@Test
	public void testing(@Optional("aaa") String testdata){
		System.out.println(System.getProperty("user.dir")+testdata);
	}
}
