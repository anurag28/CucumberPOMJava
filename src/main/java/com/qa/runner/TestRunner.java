package com.qa.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/anuraggarg/Desktop/CucumberPOM/src/main/java/com/qa/features/simplelogin.feature",
        glue = {"com/qa/stepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:test-ouput/report.html"},
        dryRun = false
)

public class TestRunner {
}
