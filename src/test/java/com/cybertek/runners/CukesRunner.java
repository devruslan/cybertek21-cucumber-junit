package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report-1.html", //cucumber-report-1.html can be renamed to anything
                "json:target/cucumber.json", //cucumber.json can be renamed to anything
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/cybertek/step_definitions",
//        dryRun = false,
//        tags = ""

)
public class CukesRunner {
}
