package MyRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\RAMYA DEEPTHI\\eclipse-workspace\\RateExchange\\src\\test\\java\\Features",
		glue = {"stepDefinition"})


public class TestRunner {

}
