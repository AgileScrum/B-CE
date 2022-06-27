package uk.co.bandce.runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/featurefile",
        //features = ".",
        glue = "uk/co/bandce",
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
                "json:target/RunCuke/cucumber.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Reports/report.html",
                "rerun:target/failedrerun.txt"  // Cucumber create the fail scenario in this file
        },
        tags = {"@smoke,@regression,@sanity"}
        )
public class TestRunner {
        @AfterClass
        public static void setUp() {
                String projectPath = System.getProperty("user.dir");
                String reportConfigPath = projectPath + "/src/test/java/resources/extentreport/extent-config.xml";
                Reporter.loadXMLConfig(reportConfigPath);
                Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
                Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
                Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
                Reporter.setSystemInfo("Selenium", "3.141.59");
                Reporter.setSystemInfo("Maven", "3.5.9");
                Reporter.setSystemInfo("Java Version", "1.8.0_151");
        }
}


