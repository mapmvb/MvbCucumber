package com.luxoft.steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class MyStepDefinition {
    private int distance;

    @Given("^(?:Lucy|Alice|Kate) is in (\\d+) m from Sean$")
    public void lucy_is_in_m_from_sean(Integer int1) {
        distance = int1;
    }

    @When("Sean shouts {string}")
    public void seanShoutsFreeBagels(String arg0) {
        System.out.println(arg0);
    }

    @Then("^Lucy (hears|not hear) Sean message$")
    public void lucyHearsSeanMessage(String arg0) {
        if (arg0.contains("not"))
            Assertions.assertFalse(distance<15);
        else
            Assertions.assertTrue(distance<15);
    }

//    @Then("Lucy not hear Sean message")
//    public void lucyNotHearSeanMessage() {
//        Assertions.assertFalse(distance<15);
//    }


    @But("Lucy is hungry")
    public void lucyIsHungry() {
        distance = 1;
    }

    @And("Lucy goes to cafe")
    public void lucyGoesToCafe() {
        while ((distance>0)){
            distance--;
        }
    }

}
