package com.luxoft.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CalcStepDefs {
    private int result =0;

    @Given("we set result equals {int}")
    public void weSetResultEquals(int result) {
        this.result = result;
    }

    @When("we add {int}")
    public void weAdd(int additionalNumber) {
        this.result += additionalNumber;
    }

    @Then("^we (have|not have) result equals (\\d+)$")
    public void weHaveResultEquals(int result) {
        Assertions.assertEquals(result, this.result);
    }

    @And("^we (add|subtract) (\\d+)$")
    public void weAddOrSubtract(String arg1, int arg0) {
        switch (arg1){
            case "add": this.result += arg0;
            case "subtract": this.result -= arg0;
        }
    }

//    @And("we subtract {int}")
//    public void weSubtract(int arg0) {
//    }
}
