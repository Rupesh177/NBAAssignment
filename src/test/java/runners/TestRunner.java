package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
         features ={"src/test/resources/Features"}
        ,glue={"glue"}
//        ,plugin = {"pretty", "html:test-output", "json:target/cucumber.json", "html:target/cucumber.html",
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        "rerun:target/FailedRerun.txt"
//}
        ,plugin = { "pretty", "html:target/cucumber-reports" }
        ,monochrome=true
)

public class TestRunner extends AbstractTestNGCucumberTests {


    }

