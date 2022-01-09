package com.luxoft.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs {

    private int distance1;
    @Given("show how background works")
    public void showHowBackgroundWorks() {
        System.out.println("222222222");
    }

    @Given("^Macy is in (\\d+) m from Kean$")
    public void macyIsInMFromKean(int arg0) {
        distance1 = arg0;
    }

    @When("^Kean shouts '([^\"]*)'$")
    public void keanShouts(String arg0) {
        System.out.println(arg0);
    }

    @Then("^.acy \\w+ Kean message$")
    public void macyHearsKeanMessage() { Assertions.assertTrue(distance1<15);
    }
}
