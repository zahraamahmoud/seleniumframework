package runner;

import io.cucumber.testng.CucumberOptions;
import tests.testbase;

/*@CucumberOptions(features ="src/test/java/features"
        ,glue = {"steps"},plugin = {"pretty","html:target/cucumberreport.html"})*/
@CucumberOptions(features ="src/test/java/features"
        ,glue = {"steps"},plugin = {"pretty","html:reports/report.html"})


public class testrunner extends testbase {
}
