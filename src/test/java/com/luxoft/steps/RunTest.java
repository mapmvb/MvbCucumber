package com.luxoft.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/luxoft/features",
        glue = "com.luxoft.steps",
//        tags = "@Shout and not @tag1",
//        tags = "@tag1 or tag2".
        tags = "@web",
        dryRun = false,
        monochrome = false,
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber5.json"}
)
public class RunTest {

    @AfterClass
    public static void closeDriver() {
        Auxillary.driver.close();

    }
}
